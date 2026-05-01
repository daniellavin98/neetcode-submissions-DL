class Solution {
    public int findKthLargest(int[] nums, int k) {
        //do a max heap
        //loop through nums and store in max heap 
        //then loop through heap and pop k times
        //the last popped in the answer

        int result = 0; 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 

        for(int num : nums){
            maxHeap.offer(num); 
        }

        for(int i = 0; i < k; i++){
            result = maxHeap.poll(); 
        }

        return result; 
    }
}
