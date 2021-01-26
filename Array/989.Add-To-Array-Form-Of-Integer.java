/*
https://leetcode.com/problems/add-to-array-form-of-integer/
*/

/*
My solution
Time O(max(m, n)) where n = length(A), m = length(K)
Space O(max(m, n)) (because have to return a list of integers)
The catch: pay attention to the length of 2 elements when doing problems like this one. 
Have to loop through the longer element. If the shorter element 'exhaust', set the number needs to be added to 0 
*/
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> answer = new ArrayList<>();
        int n = A.length-1;
        int ALastDigit = 0, KlastDigit = 0, sum = 0, newDigit = 0, carry = 0;
        while(n >= 0 || K > 0) {
            if(n < 0) {
                ALastDigit = 0;
            } else {
                ALastDigit = A[n];
            }
            
            KlastDigit = K % 10;
        
            sum = ALastDigit + KlastDigit + carry;
            
            newDigit = sum % 10;
            carry = sum / 10;
            K = K / 10;
            
            answer.add(newDigit);
            
            n--;
        }
        
        if(carry != 0) {
            answer.add(carry);
        }
        
        Collections.reverse(answer);
        return answer;
    }
}


