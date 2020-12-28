/*
https://leetcode.com/problems/group-anagrams/
*/


// Using hashtable
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<List<String>>();
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = hash(strs[i]);
            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            } 
            map.get(s).add(strs[i]);
        }
        
        for(List<String> list : map.values()) {
            answer.add(list);
        }
        
        return answer;
    }
    
    // shit, can't think of a hashing-into-integer function
    // hash a string by mapping it to its sorted version
    public String hash(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }    
}


/* Using unique prime multiplication
Hash function would be:
  int hashValue = 1;
  for every character in a string:
    hashValue *= (int) map.get(char)

Map would be {'a': 2, 
                  'b': 3, 
                  'c': 5, 
                  'd': 7, 
                  'e': 11, 
                  'f': 13,
                  'g': 17,
                  'h': 19,
                  'i': 23,
                  'j': 29,
                  'k': 31,
                  'l': 37,
                  'm': 41,
                  'n': 43,
                  'o': 47,
                  'p': 53,
                  'q': 59,
                  'r': 61,
                  's': 67, 
                  't': 71,
                  'u': 73,
                  'v': 79,
                  'w': 83,
                  'x': 89,
                  'y': 97,
                  'z': 101
                 }
i.e. successive prime values.
*/



