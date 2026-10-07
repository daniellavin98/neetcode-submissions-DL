class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(); 

        int i = 0; 
        int n = words.length; 

        while(i < n){
            //Greedily pack words into current line 
            int lineLen = words[i].length(); 
            int j = i + 1; 

            while(j < n && lineLen + 1 + words[j].length() <= maxWidth){
                lineLen += 1 + words[j].length(); 
                j++; 
            }

            int numWords = j - i; 
            int totalChars = 0; 
            
            for(int k = i; k < j; k++){
                totalChars += words[k].length(); 
            }

            int numSpaces = maxWidth - totalChars; 

            StringBuilder line = new StringBuilder(); 

            //Last line or single word: Left justify 
            if(j == n || numWords == 1){
                for(int k = i; k < j; k++){
                    if(k > i){
                        line.append(" "); 
                    }
                    line.append(words[k]); 
                }
                while(line.length() < maxWidth){
                    line.append(" "); 
                }
            }
            else{
                int gaps = numWords - 1; 
                int gapSpace = numSpaces / gaps; 
                int extra = numSpaces % gaps; 
                
                for(int k = i; k < j - 1; k++){
                    line.append(words[k]); 
                    int sp = gapSpace + (k - i < extra ? 1 : 0); 

                    for(int s = 0; s < sp; s++){
                        line.append(" "); 
                    }
                }
                line.append(words[j-1]); 
            }

            result.add(line.toString()); 
            i = j; 
        }

        return result;
    }
}