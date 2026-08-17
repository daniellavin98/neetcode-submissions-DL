class Solution {
    //want the most frequent char at start 
    //once a char has been added to string, must be put on hold
    //then add most frequent char again
    //use a hashmap or frequency array  
    //to find most frequent use a max heap of count character pairs
    //so track the prev element, if exists but max heap is empty return empty string
    //pop the top element, decrement its count 
    //push prev back to max heap if still exists 
    //set prev to current if count still positive 
    public String reorganizeString(String s) {
        int[] freq = new int[26]; 
        for(char c : s.toCharArray()){
            freq[c - 'a']++; 
        }

        //max heap 
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]); 

        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                maxHeap.offer(new int[]{freq[i], i}); 
            }
        }

        StringBuilder result = new StringBuilder(); 
        int[] prev = null; 

        while(!maxHeap.isEmpty() || prev != null){
            if(prev != null && maxHeap.isEmpty()){
                return ""; 
            }

            int[] curr = maxHeap.poll(); 
            result.append((char) (curr[1] + 'a')); 
            curr[0]--; 

            if(prev != null){
                maxHeap.offer(prev); 
                prev = null; 
            }

            if(curr[0] > 0){
                prev = curr; 
            }
        }

        return result.toString(); 
    }
}