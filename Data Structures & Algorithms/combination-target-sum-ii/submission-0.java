class Solution {
    //dont want duplicate subsets 
    //sort the array 
    //skip duplicate numbers
    
    List<List<Integer>> result = new ArrayList<>(); 
    List<Integer> current = new ArrayList<>(); 

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates); 
        backtrack(candidates, target, 0); 

        return result; 
    }

    private void backtrack(int [] arr, int target, int index){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return; 
        }

        for(int i = index; i < arr.length; i++){
            if(arr[i] > target) break; 

            if(i > index && arr[i] == arr[i-1]) continue; 

            current.add(arr[i]);

            backtrack(arr, target - arr[i], i+1); 

            current.remove(current.size() - 1); 
        }
    }
}
