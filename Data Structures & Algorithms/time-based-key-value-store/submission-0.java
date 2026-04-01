//For set - use a hash map 
//key is the string key
//value is tree map where the key is the timestamp and the value is the string value 
//use a tree map because it stores key-value pairs in a sorted order

class TimeMap {

    private Map<String, TreeMap<Integer, String>> map; 

    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        map
        .computeIfAbsent(key, k -> new TreeMap<>())
        .put(timestamp, value); 
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        //this retrieves the value for key and places in a tree map
        TreeMap<Integer, String> timeValueMap = map.get(key); 

        //find the largest time stamp that is <= query time stamp
        //do this by using floor key 

        Integer timeStamp = timeValueMap.floorKey(timestamp); 

        return timeStamp == null ? "" : timeValueMap.get(timeStamp);  
    }
}
