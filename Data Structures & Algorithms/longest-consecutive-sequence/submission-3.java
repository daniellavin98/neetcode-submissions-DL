class Solution {
    public int longestConsecutive(int[] nums) {
        //two pointers
        //sort the array, then check the differences between i and j 
        //if j is one greater than i, add one to result, then move pointer 
        //if they are the same, move pointers but dont add to result 
        //if difference is greater, move pointers but return result to one
        //return result

        //This was too long
        //We dont want to deal with duplicates, so use a hash set 
        //put all elements in hash set
        //then loop through hash set
        //if the set does not contain num - 1, no sequence so set the length of sequence to one
        //them while it contains num + length, increment length
        //then check for longest
        //Time = O(n)
        //Space = O(n)

        
        int result = 0;

        HashSet<Integer> numSet = new HashSet<>(); 

        for(int num : nums){
            numSet.add(num); 
        }

        for(int num : numSet){
            if(!numSet.contains(num - 1)){
                int length = 1; 

                while(numSet.contains(num + length)){
                    length++;
                }

                result = Math.max(result, length); 
            }
        }

        return result; 

        


    }
}
