/*
https://leetcode.com/problems/integer-to-english-words/
*/

/*
My approach
*/
class Solution {
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        String input = Integer.toString(num);
        int n = input.length();
        int i = n-1;
        int counter = 0;
        Map<Integer, String> values = new HashMap<>();
        Map<Integer, String> digitToString = new HashMap<>();
        Map<Integer, String> tensToString = new HashMap<>();
        
        values.put(0, "");
        values.put(1, "Thousand");
        values.put(2, "Million");
        values.put(3, "Billion");
        
        digitToString.put(0, "");
        digitToString.put(1, "One");
        digitToString.put(2, "Two");
        digitToString.put(3, "Three");
        digitToString.put(4, "Four");
        digitToString.put(5, "Five");
        digitToString.put(6, "Six");
        digitToString.put(7, "Seven");
        digitToString.put(8, "Eight");
        digitToString.put(9, "Nine");
        
        tensToString.put(0, "");
        tensToString.put(10, "Ten");
        tensToString.put(11, "Eleven");
        tensToString.put(12, "Twelve");
        tensToString.put(13, "Thirteen");
        tensToString.put(14, "Fourteen");
        tensToString.put(15, "Fifteen");
        tensToString.put(16, "Sixteen");
        tensToString.put(17, "Seventeen");
        tensToString.put(18, "Eighteen");
        tensToString.put(19, "Nineteen");
        
        tensToString.put(20, "Twenty");
        tensToString.put(30, "Thirty");
        tensToString.put(40, "Forty");
        tensToString.put(50, "Fifty");
        tensToString.put(60, "Sixty");
        tensToString.put(70, "Seventy");
        tensToString.put(80, "Eighty");
        tensToString.put(90, "Ninety");
        tensToString.put(100, "Hundred");
        
        
        while(i >= 0) {
            String subNum = input.substring(Math.max(0, i-2), i + 1);
            System.out.println(subNum);
            String str = readGroupOfThree(subNum, digitToString, tensToString);
            if(!str.isEmpty()) {
                str += values.get(counter);
                str += " ";
            }
            sb.insert(0, str);
            counter++;
            i -= 3;
        }
        return sb.toString().trim();
    }
    
    
    private String readGroupOfThree(String s, Map<Integer, String> digitToString, Map<Integer, String> tensToString) {
        if(s.equals("000")) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int num = Integer.parseInt(s);
        int counter = 3;
        boolean countedAsTheTens = false;
        while(num != 0) {
            int lastDigit = num % 10;
            String str = "";
            if(counter == 3) {
                int x = num;
                x /= 10;
                if(x % 10 == 1) {
                    int t = 10 + lastDigit;
                    str = tensToString.get(t);
                    countedAsTheTens = true;
                } else {
                    str = digitToString.get(lastDigit);
                }
            } else if(counter == 2) {
                if(!countedAsTheTens) {
                    lastDigit *= 10;
                    str = tensToString.get(lastDigit);
                } 
            } else if(counter == 1) {
                if(lastDigit != 0) {
                    str = (digitToString.get(lastDigit) + " Hundred");     
                }  
            }
            
            if(!str.isEmpty()) {
                str += " ";
            }
            num /= 10;
            counter--;
            res.insert(0, str);
        }
        return res.toString();
    }
}
