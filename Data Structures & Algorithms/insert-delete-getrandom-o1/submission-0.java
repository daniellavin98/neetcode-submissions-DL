class RandomizedSet {
    private HashMap<Integer, Integer> numMap; 
    private List<Integer> numList; 
    private Random rand; 

    public RandomizedSet() {
        numMap = new HashMap<>();
        numList = new ArrayList<>(); 
        rand = new Random();  
    }
    
    public boolean insert(int val) {

        if(!numMap.containsKey(val)){
            numMap.put(val, numList.size()); 
            numList.add(val);  
            return true;
        }

        return false; 
    }
    
    public boolean remove(int val) {

        if(numMap.containsKey(val)){
            int idx = numMap.get(val);
            int last = numList.get(numList.size() - 1);  
            numList.set(idx, last); 
            numList.remove(numList.size() - 1); 
            numMap.put(last, idx); 
            numMap.remove(val); 
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        return numList.get(rand.nextInt(numList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */