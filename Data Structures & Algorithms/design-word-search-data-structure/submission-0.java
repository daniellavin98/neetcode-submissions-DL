public class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>(); 
    boolean endOfWord = false; 
}

// public class TrieNode{
//     HashMap<Character, TrieNode> children = new HashMap<>(); 
//     boolean endOfWord = false; 
// }

//need to use dfs for search 
class WordDictionary {

    private TrieNode root; 

    public WordDictionary() {

        root = new TrieNode(); 
    }

    public void addWord(String word) {

        TrieNode curr = root; 

        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode()); 
            curr = curr.children.get(c); 
        }

        curr.endOfWord = true; 
    }

    public boolean search(String word) {
        return dfsHelper(word, 0, root); 
    }

    private boolean dfsHelper(String word, int num, TrieNode root){
        if(num == word.length()){
            return root.endOfWord; 
        }
        
        TrieNode curr = root;

        char c = word.charAt(num); 

        if(c == '.'){
            for(TrieNode child : curr.children.values()){
                if(dfsHelper(word, num + 1, child)){
                    return true; 
                }
            }
            return false; 
        }
        else{
            TrieNode next = curr.children.get(c); 
            return next != null && dfsHelper(word, num + 1, next); 
        }


    }
}
