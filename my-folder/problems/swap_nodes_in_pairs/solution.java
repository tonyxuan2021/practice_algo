// Recursive approach
// T: O(n) - need to perform constant calculation on each node
// S: O(n) - for call stack space (n/2) or n
class Solution {
    public ListNode swapPairs(ListNode head) {
        // base case
        if(head == null || head.next == null) return head;
        
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        
        // swap nodes
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        
        return secondNode;
    }
}