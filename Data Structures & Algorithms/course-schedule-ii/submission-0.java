class Solution {
    //need a hash map to map courses to prereqs 

    private HashMap<Integer, List<Integer>> preMap = new HashMap<>(); 

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Track in-degrees
        int[] inDegree = new int[numCourses]; 
        //fill in hash map

        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>()); 
        }

        // Populate the graph: prerequisites[i] = [course, prereq]
        // Meaning: prereq -> course
        for(int[] pair : prerequisites){
            int course = pair[0]; 
            int prereq = pair[1]; 

            preMap.get(prereq).add(course); 
            inDegree[course]++;     //increment dependency count for this course 
        }

        // 2. Initialize the queue with all courses that have 0 prerequisites
        Queue<Integer> queue = new LinkedList<>(); 
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i); 
            }
        }

        //Process courses level by level 
        int[] order = new int[numCourses]; 
        int index = 0; 

        while(!queue.isEmpty()){
            int currentCourse = queue.poll(); 
            order[index++] = currentCourse; 

            //get all courses that depend on completed course
            List<Integer> neighbours = preMap.get(currentCourse); 
            for(int neighbour : neighbours){
                inDegree[neighbour]--;      //remove dependency

                //if all prereqs are cleared add to queue
                if(inDegree[neighbour] == 0){
                    queue.offer(neighbour); 
                }

            }
        }

        //verify if a cycle exists -> we cant finish all courses
        if(index == numCourses){
            return order; 
        }
        else{
            return new int[0]; 
        }
    }
}
