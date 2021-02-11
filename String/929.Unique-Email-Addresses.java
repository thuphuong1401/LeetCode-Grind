/*
https://leetcode.com/problems/unique-email-addresses/
*/

/*
Big idea: 
- "Normalize" each email in the given list by removing parts after "+" and removing "."
- Add each normalized email to a hashset
- Answer is size of hashset
*/
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            String[] sep = email.split("@");
            String[] part = sep[0].split("\\+");
            String newEmail = part[0].replace(".", "") + "@" + sep[1];
            set.add(newEmail);
        }
        return set.size();
    }
}
