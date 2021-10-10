/*
https://leetcode.com/problems/reveal-cards-in-increasing-order/
*/

/*
My solution, around O(n^2)
*/
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] ans = new int[n];
        Arrays.sort(deck);
        boolean[] filled = new boolean[n];
        int readIndex = 0;
        int writeIndex = 0;
        
        int numUnoccupied = 2;
        
        while(readIndex < n) {
            
            writeIndex %= n;
            
            if(numUnoccupied == 2 && !filled[writeIndex]) {
                ans[writeIndex] = deck[readIndex];
                numUnoccupied = 1;
                filled[writeIndex] = true;
                writeIndex++;
                readIndex++;
            } else if(!filled[writeIndex]) {
                numUnoccupied++;
                writeIndex++;
            } else {
                writeIndex++;
            }
        }
        
        return ans;
    }
}


/*
O(n log n)
*/
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> indexQueue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            indexQueue.add(i);
        }
        Arrays.sort(deck);
        int[] ans = new int[n];
        for(int card : deck) {
            ans[indexQueue.remove()] = card;
            if(!indexQueue.isEmpty()) {
                int top = indexQueue.remove();
                indexQueue.add(top);
            }
        }
        return ans;
    }
}
