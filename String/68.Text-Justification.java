/*
https://leetcode.com/problems/text-justification/
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        int index = 0;
        while(index < words.length) {
            int spacesCount = 0;
            int wordSpacesCount = 0;
            
            List<String> currLine = new ArrayList<>();
            while(index < words.length) {
                if(spacesCount + (words[index].length() + 1) <= maxWidth) {
                    spacesCount += (words[index].length() + 1);
                    currLine.add(words[index]);
                    wordSpacesCount += words[index].length();
                    index++;
                } else if(spacesCount + words[index].length() == maxWidth) {
                    spacesCount += words[index].length();
                    currLine.add(words[index]);
                    wordSpacesCount += words[index].length();
                    index++;
                    break;
                } else {
                    break;
                }
            }
            
            int emptySpaces = maxWidth - wordSpacesCount;
            int numWords = currLine.size();
            int r;
            StringBuilder line = new StringBuilder();
            
            if(numWords == 1) {
                r = 0;
                String w = currLine.get(numWords - 1);
                line.append(w);
                int numSpacesLeft = maxWidth - w.length();
                for(int i = 0; i < numSpacesLeft; i++) {
                    line.append(" ");
                }
                answer.add(line.toString());
            } else {
                r = emptySpaces % (numWords - 1);
                for(int i = 0; i < numWords - 1; i++) {
                    line.append(currLine.get(i));
                    StringBuilder spaces = new StringBuilder();
                    if(r > 0) {
                        spaces.append(" ");
                        r--;
                    }
                    int t = emptySpaces / (numWords - 1);
                    for(int j = 0; j < t; j++) {
                        spaces.append(" ");
                    }
                    line.append(spaces);
                }
            
                line.append(currLine.get(numWords - 1));
                answer.add(line.toString());   
            }
        }
        
        String lastLine = answer.get(answer.size() - 1);
        answer.remove(answer.size() - 1);
        String[] tokens = lastLine.split("\\s+");
        
        int space = 0;
        StringBuilder newLastLine = new StringBuilder();
        for(int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            newLastLine.append(t);
            if(i != tokens.length - 1) {
                newLastLine.append(" ");
                space += (t.length() + 1);
            } else {
                space += t.length();
            }
        }
        
        for(int i = 0; i < (maxWidth - space); i++) {
            newLastLine.append(" ");
        }
        
        answer.add(newLastLine.toString());
        return answer;
    }
}
