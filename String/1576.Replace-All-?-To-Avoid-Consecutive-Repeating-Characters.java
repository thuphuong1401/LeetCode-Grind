/*
https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
*/

/*
My very extra solution.
*/
class Solution {
    public String modifyString(String s) {
        int n = s.length();
        if(n == 1) {
            if(s.charAt(0) == '?') {
                return "a";
            } else {
                return s;
            }
        }
        
        int prev = -1;
        int curr = 0;
        int next = 1;
        
        char[] sArray = s.toCharArray();
        
        while(curr < n) {
            Character prevChar = null, currChar = null, nextChar = null;
            currChar = sArray[curr];
            if(!currChar.equals(new Character('?'))) {
                curr++;
                prev++;
                next++;
                continue;
            }
            
            if(prev >= 0) {
                prevChar = sArray[prev];
            }
            
            if(next < n) {
                nextChar = sArray[next];
            }
            
            char firstValid = findFirstValidChar(prevChar, nextChar);
            sArray[curr] = firstValid;    
            
            curr++;
            prev++;
            next++;
            
        }
        
        return String.valueOf(sArray);
        
    }
    
    
    private char findFirstValidChar(Character prevChar, Character nextChar) {
        char ans = 'a';
        if(prevChar != null && nextChar != null) {
            if(nextChar.equals(new Character('?'))) {
                ans = differentFromOneCharacter(prevChar);
            } else {
                ans = differentFromTwoCharacters(prevChar, nextChar);
            }
        } else if(prevChar != null) {
            ans = differentFromOneCharacter(prevChar);
        } else {
            ans = differentFromOneCharacter(nextChar);
        }
        
        return ans;    
    }
    
    
    private char differentFromOneCharacter(Character c) {
        char ans = 'a';
        for(int i = 0; i < 26; i++) {
            char t = (char)('a' + i);
            Character temp = new Character(t);
            if(!temp.equals(c)) {
                ans = t;
                break;
            }
        }
        return ans;
    }
    
    private char differentFromTwoCharacters(Character c1, Character c2) {
        char ans = 'a';
        for(int i = 0; i < 26; i++) {
            char t = (char)('a' + i);
            Character temp = new Character(t);
            if(!temp.equals(c1) && !temp.equals(c2)) {
                ans = t;
                break;
            }
        }
        return ans;
    }
    
}



/*
A simple O(N) solution based on the observation that to create a sequence of non-repeating character, only needs a, b, and c
*/
class Solution {
    public String modifyString(String s) {
        int n = s.length();
        if(n == 1) {
            if(s.charAt(0) == '?') {
                return "a";
            } else {
                return s;
            }
        }
        char[] sArray = s.toCharArray();
        for(int i = 0; i < n; i++) {
            char curr = sArray[i];
            if(curr == '?') {
                if(i == 0) {
                    sArray[i] = findCharacterDifferentFromOneCharacter(sArray[i+1]);
                } else if(i == n-1) {
                    sArray[i] = findCharacterDifferentFromOneCharacter(sArray[i-1]);
                } else {
                    sArray[i] = findCharacterDifferentFromTwoCharacters(sArray[i-1], sArray[i+1]);
                }
            }
        }
        return String.valueOf(sArray);
    }
    
    private char findCharacterDifferentFromOneCharacter(char c) {
        char ans = 'a';
        for(char ind = 'a'; ind <= 'c'; ind++) {
            if(ind != c) {
                ans = ind;
                break;
            }
        }
        return ans;
    }
    
    private char findCharacterDifferentFromTwoCharacters(char c1, char c2) {
        char ans = 'a';
        for(char ind = 'a'; ind <= 'c'; ind++) {
            if(ind != c1 && ind != c2) {
                ans = ind;
                break;
            }
        }
        return ans;
    }
    
}

