/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */

/*
First solution
*/
class Solution {
    public void findSecretWord(String[] wordList, Master master) {
        int n = wordList.length;
        Random rand = new Random();
        
        for(int i = 0; i < 10; i++) {
            // Step 1: guess the word
            int randInt = rand.nextInt(wordList.length);
            String word = wordList[randInt];
            
            // Step 2: use the guessed word, narrow down search space
            int match = master.guess(word);
            if(match == 6) {
                return;
            }
            List<String> newList = new ArrayList<>();
            for(String s : wordList) {
                if(numMatch(word, s) == match) {
                    newList.add(s);
                }
            }
            wordList = array(newList);
        }
    }
    
    
    private String[] array(List<String> list) {
        String[] ans = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    
    private int numMatch(String s1, String s2) {
        int match = 0;
        for(int i = 0; i < 6; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 == c2) {
                match++;
            }
        }
        return match;
    }
}


/*
Second solution
Big idea: guess word with fewest number of 0 matches every time => if master.guess(word) = 0 (with chance 80%), newList will be minimized.
*/
class Solution {
    public void findSecretWord(String[] wordList, Master master) {
        int n = wordList.length;
        Random rand = new Random();
        
        for(int i = 0; i < 10; i++) {
            
            wordList = shuffle(wordList);
            
            // Step 1: guess the word
            Map<String, Integer> numZeroMatch = new HashMap<>();
            String choice = "";
            int minMatch = 10000;
            for(String word : wordList) {
                numZeroMatch.put(word, 0);
                for(String w : wordList) {
                    if(numMatch(word, w) == 0) {
                        numZeroMatch.put(word, numZeroMatch.get(word) + 1);
                    }
                }
                if(numZeroMatch.get(word) < minMatch) {
                    minMatch = numZeroMatch.get(word);
                    choice = word;
                }
            }
            
            String word = choice;
            
            /*
            newList = list of zero matches of randomly guessed word // sai
            */
            
            // Step 2: use the guessed word, narrow down search space
            int match = master.guess(word);
            if(match == 6) {
                return;
            }
            List<String> newList = new ArrayList<>();
            for(String s : wordList) {
                if(numMatch(word, s) == match) {
                    newList.add(s);
                }
            }
            wordList = array(newList);
        }
    }
    
    
    private String[] array(List<String> list) {
        String[] ans = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    
    private int numMatch(String s1, String s2) {
        int match = 0;
        for(int i = 0; i < 6; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 == c2) {
                match++;
            }
        }
        return match;
    }

    
    private String[] shuffle(String[] wordList) {
        List<String> tempList = Arrays.asList(wordList);
        Collections.shuffle(tempList);
        return array(tempList);    
    }
    
}

