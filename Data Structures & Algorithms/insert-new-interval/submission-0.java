class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //sort intervals array 
        //then compare end of interval to beginning of newinterva
        //if end less than, store in new array 
        //if greater than the end, overlap 
        //create a new overlappinh interval with less than value on left as start, and greater value on right as end 
        //then add all intervals after new interval

        List<int[]> result = new ArrayList<>(); 

        int i = 0; 
        int n = intervals.length; 

        //add all intervals than come before new interval
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]); 
            i++; 
        }

        //merge all overlapping intervals with new interval
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]); 
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;  
        }

        result.add(newInterval); 

        //add all intervals after new interval 
        while(i < n){
            result.add(intervals[i]); 
            i++; 
        }

        return result.toArray(new int[result.size()][]); 
    }
}
