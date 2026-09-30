class Solution {
    private static final HashMap<Character, String> map = new HashMap<>(); 
    static{
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    private List<String> result = new ArrayList<>();
    private StringBuilder current = new StringBuilder(); 

    private String inputDigits; 

    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.isEmpty()){
            return result; 
        }

        inputDigits = digits;
        backtrack(0); 

        return result;  
    }

    private void backtrack(int index){
        if(index == inputDigits.length()){
            result.add(current.toString()); 
            return; 
        }

        char digit = inputDigits.charAt(index); 
        String letters = map.get(digit); 

        //if number is invalid - 0 or 1
        if(letters == null){
            backtrack(index + 1); 
            return; 
        }

        //loop through all letters
        for(int i = 0; i < letters.length(); i++){
            current.append(letters.charAt(i)); 
            backtrack(index + 1); 
            current.deleteCharAt(current.length() - 1); 
        }
    }
}
