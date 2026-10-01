class Solution {
    //length of current will be 2 * n
    //can add ( if the number of ( is less than n
    //can add ) if the number of ) is less than number of (
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, "", 0, 0); 

        return result; 
    }

    private void backtrack(int n, String current, int open, int close){
        if(current.length() == 2 * n){
            result.add(current.toString()); 
            return; 
        }

        if(open < n){
            backtrack(n, current + "(", open + 1, close);
        }

        if(close < open){
            backtrack(n, current + ")", open, close + 1); 
        }
    }
}
