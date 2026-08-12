class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the array 
        //compare end of one to beginning of other
        //if end is greater than -> overlap 
        if(intervals.length <= 1){
            return intervals; 
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); 

        List<int[]> result = new ArrayList<>(); 

        int[] currInterval = intervals[0]; 
        result.add(currInterval); 

        //loop through
        for(int[] interval : intervals){
            int currBegin = currInterval[0]; 
            int currEnd = currInterval[1]; 
            int nextBegin = interval[0]; 
            int nextEnd = interval[1];

            if(currEnd >= nextBegin){
                currInterval[1] = Math.max(currEnd, nextEnd); 
            } 
            else{
                currInterval = interval; 
                result.add(currInterval);
            }
        }

        return result.toArray(new int[result.size()][]); 
    }
}
