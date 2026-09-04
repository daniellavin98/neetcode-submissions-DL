class Solution {
    //for backtrack problems always need a result and current list 
    //have two choices, whether to include current value in combination or not 
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> current = new ArrayList<>();

    private int k; 
    private int n; 

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k; 

        backtrack(1); 

        return result; 
    }

    private void backtrack(int currentNum){
        if(current.size() == k){
            result.add(new ArrayList<>(current)); 
            return;
        }

        if(currentNum > n) return;

        //Choice 1
        current.add(currentNum); 
        backtrack(currentNum + 1); 

        //Choice 2
        current.remove(current.size() - 1); 
        backtrack(currentNum + 1); 
    }
}