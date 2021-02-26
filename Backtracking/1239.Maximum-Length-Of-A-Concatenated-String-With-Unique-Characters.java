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





