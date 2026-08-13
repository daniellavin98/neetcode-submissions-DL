class Solution {
    public int romanToInt(String s) {
        //use a hash table 
        Map<Character, Integer> table = new HashMap<>(); 

        table.put('I', 1); 
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);   
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);

        int sum = 0; 
        int prevValue = 0; 

        for(int i = s.length()-1; i >= 0; i-- ){
            char c = s.charAt(i); 
            int data = table.get(c); 

            if(data < prevValue){
                sum -= data; 
            }else{
                sum += data; 
            }

            prevValue = data; 
        }   

        return sum; 

    }
}