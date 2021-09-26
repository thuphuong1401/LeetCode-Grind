/*
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
*/

/*
Pure backtracking - My implementation
*/
class Solution {
    int max = 0;
    
    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0) {
            return 0;
        }
        backtracking(arr, "", 0);
        return max;
    }
    
    private void backtracking(List<String> arr, String path, int index) {
        boolean containsAllUniqueChars = isUnique(path);
        
        if(containsAllUniqueChars) {
            max = Math.max(max, path.length());
        }
        
        if(index == arr.size() || !containsAllUniqueChars) {
            return;
        }
        
        for(int i = index; i < arr.size(); i++) {
            String currChoice = arr.get(i);
            backtracking(arr, path+currChoice, i+1);
        }
    }
    
    
    private boolean isUnique(String sb) {
        Set<Character> set = new HashSet<>();
        for(char c : sb.toCharArray()) {
            set.add(c);
        }
        return set.size() == sb.length();
    }   
}


// brute force
class Solution {
    public int maxLength(List<String> arr) {
        List<String> dp = new ArrayList<>();
        dp.add("");
        for(String curr : arr) {
            if(!unique(curr)) {
                continue;
            } 
            List<String> temp = new ArrayList<>();
            for(String cand : dp) {
                String newCand = cand + curr;
                if(unique(newCand)) {
                    temp.add(newCand);
                }
            }
            dp.addAll(temp);
        }
        
        int max = 0;
        for(String s : dp) {
            max = Math.max(max, s.length());
        }
        return max;
    }
    
    
    private boolean unique(String s) {
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() == s.length();
    }
    
}



/*
Backtracking
*/
class Solution {
    int ans;
    
    public int maxLength(List<String> arr) {
        ans = 0;
        backtracking(arr, new StringBuilder(), 0);        
        return ans;
    }
    
    
    private void backtracking(List<String> arr, StringBuilder sb, int index) {
        
        int currLength = sb.length();
        ans = Math.max(ans, currLength);
        
        if(index == arr.size()) {
            return;
        }
        
        for(int i = index; i < arr.size(); i++) {
            StringBuilder temp = new StringBuilder(sb);
            String cand = arr.get(i);
            temp.append(cand);
            if(allUniqueCharacters(temp.toString())) {
                int l = sb.length();
                sb.append(cand);
                backtracking(arr, sb, i + 1);
                sb.setLength(l);
            }
        }
    }
    
    
    private boolean allUniqueCharacters(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() == n;
    }
}



