
// Recursive Approach
// T: O(m + n)
// S: O(m + n)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // base cases, we do not want null pointer exception
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            // // return head of our merged LL
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            // return head of our merged LL - this grows as call stack returns heads 
            return list2;
        }
    }
}