class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); 

        for(int i : stones){
            queue.add(i); 
        }

        while(queue.size() > 1){
            int y = queue.poll();
            int x = queue.poll();

            if(x != y){
                queue.add(y - x); 
            }
        }

        return queue.size() == 0 ? 0 : queue.peek();
    }
}
