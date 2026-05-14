//explore all combination of numbers that add up to value 
//for each element, reduce target by value
//if target becomes zero, found combination
//if goes negative, backtrack

class Solution {
    List<List<Integer>> result = new ArrayList<>(); 
    List<Integer> current = new ArrayList<>();

    private void backtrack(int[] arr, int target, int index){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return; 
        }

        if(target < 0 || index >= arr.length){
            return; 
        }

        current.add(arr[index]); 

        backtrack(arr, target - arr[index], index);

        current.remove(current.size() - 1); 

        backtrack(arr, target, index + 1);  

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        backtrack(nums, target, 0); 

        return result; 
    }
}
