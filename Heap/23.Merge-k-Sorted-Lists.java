/*
https://leetcode.com/problems/merge-k-sorted-lists/
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
Min heap solution
Brute force approach, somehow. This approach stores all the nodes of all the lists in a min heap, then poll from that min heap to create a sorted linkedlist
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = lists.length;
        for(int i = 0; i < n; i++) {
            ListNode currList = lists[i];
            while(currList != null) {
                pq.add(currList.val);
                currList = currList.next;
            }
        }
        
        ListNode merged = new ListNode();
        ListNode temp = merged;
        
        while(!pq.isEmpty()) {
            temp.next = new ListNode(pq.remove());
            temp = temp.next;
        }
        
        return merged.next;
    }
}


/*
Min heap approach, space optimzed. A min heap only contains at most k elements (1 pointer for each linked list)
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.val, node2.val));
        
        
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        
        while(!pq.isEmpty()) {
            ListNode smallest = pq.remove();
            temp.next = smallest;
            temp = temp.next;
            if(smallest.next != null) {
                pq.add(smallest.next);    
            }
        }
        return newHead.next;
    }
}

