class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //need to use a max heap to find maxium in each window
        //first 3 are easy, then we need to remove element i-k from max heap each time


        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0; 

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0])); 

        for(int i = 0; i < k; i++){
            int[] element = {nums[i], i}; 
            maxHeap.offer(element); 
        }

        result[resultIndex++] = maxHeap.peek()[0]; 

        for(int i = k; i < nums.length; i++){
            int[] element = {nums[i], i}; 
            maxHeap.offer(element); 

            while(!maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k){
                maxHeap.poll(); 
            }

            result[resultIndex++] = maxHeap.peek()[0]; 
        }

        

        return result; 
    }
}
