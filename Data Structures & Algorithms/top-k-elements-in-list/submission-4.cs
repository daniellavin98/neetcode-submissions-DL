public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        
        int[] result = new int[k]; 

        Dictionary<int, int> freq = new Dictionary<int, int>(); 

        for(int i = 0; i < nums.Length; i++){
            if(!freq.ContainsKey(nums[i])){
                freq[nums[i]] = 1;
            }
            else{
                freq[nums[i]]++; 
            }
        }

        PriorityQueue<int, int> minHeap = new PriorityQueue<int, int>();

        foreach(var entry in freq){
            minHeap.Enqueue(entry.Key, entry.Value); 

            if(minHeap.Count > k){
                minHeap.Dequeue();
            }

        }

        for(int i = 0; i < k; i++){
            result[i] = minHeap.Dequeue();
        }

        return result;


    }
}
