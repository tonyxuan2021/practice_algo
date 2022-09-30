
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        // keep calling recursive stack all the way until the end of our LL
        ListNode newHead = reverseList(head.next);
        
        // have previous node point to curr node
        head.next.next = head;
        // have curr node point to null
        head.next = null;
        
        return newHead;
    }
}