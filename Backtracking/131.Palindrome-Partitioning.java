/*
https://leetcode.com/problems/palindrome-partitioning/
*/

class Solution {
    List<List<String>> ans;
    Map<String, Boolean> palindromes;
    
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        palindromes = new HashMap<>();
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }
    
    
    private void backtrack(String s, int index, List<String> list) {
        if(index >= s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = index; i < s.length(); i++) {
            String curr = s.substring(index, i + 1);
            boolean b;
            if(palindromes.containsKey(curr)) {
                b = palindromes.get(curr);
            } else {
                b = isPalindrome(curr);
                palindromes.put(curr, b);
            }
            if(!b) {
                continue;
            }
            list.add(curr); 
            backtrack(s, i + 1, list); // place another separator ^^
            list.remove(list.size() - 1);
        }
    }
    
    /*
    private boolean allIsPalindromes(List<String> list) {
        boolean ans = true;
        for(String t : list) {
            if(!isPalindrome(t)) {
                ans = false;
                break;
            }
        }
        return ans;
    }
    */
    
    private boolean isPalindrome(String s) {
        boolean ans = true;
        int n = s.length();
        for(int i = 0; i < n/2; i++) {
            if(s.charAt(i) != s.charAt(n-i-1)) {
                ans = false;
                break;
            }
        }
        return ans;
    }
    
    
}

