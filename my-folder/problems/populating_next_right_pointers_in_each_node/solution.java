// Using prev established next pointers approach
// T: O(n) - we process each node once
// S: O(1) - we do not use any additional data structure for traversing nodes
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Node leftmost = root;
        
        while(leftmost.left != null){
            Node head = leftmost;
            
            while(head != null){
                // Connection 1
                head.left.next = head.right;
                
                // Connection 2
                if(head.next != null) head.right.next = head.next.left;
                
                // move along our node in current level
                head = head.next;
            }
            
            // move onto the next level
            leftmost = leftmost.left;
        }
        
        return root;
    }
}