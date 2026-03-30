class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //create a min heap
        //add (frequency, value) pairs to min heap
        //once the heap grows past k, remoce the smallest
        int[] result = new int[k]; 

        HashMap<Integer, Integer> freq = new HashMap<>(); 

        for(int i = 0; i < nums.length; i++){
            if(!freq.containsKey(nums[i])){
                freq.put(nums[i], 1); 
            }
            else{
                freq.put(nums[i], freq.get(nums[i])+1); 
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]); 

        for(HashMap.Entry<Integer, Integer> entry : freq.entrySet()){
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()}); 

            if(minHeap.size() > k){
                minHeap.poll(); 
            }
        }

        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll()[1]; 
        }

        return result; 
    }
}
