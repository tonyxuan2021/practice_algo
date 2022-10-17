// Recursive solution -> inorder (left, root, right)
// T: O(n) - need to set up pointers and traverse through every node
// S: O(n) - worst case, BST is skewed and we need to keep n nodes in our stack
class Solution {
    Node first, last = null;
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        helper(root);
        
        // last step (after we exit our helper recursion), we close our doubly LL loop (right is next, left is prev)
        first.left = last;
        last.right = first;
        
        return first;
    }
    
    private void helper(Node node){
        // base case 
        if(node == null) return;
        
        // inorder (left, root, right)'
        // left
        helper(node.left);
        
        // root
        if(last != null){
            // update our pointers
            last.right = node;
            node.left = last;
        } else{ // we are at the very left node (smallest), so last == null
            // track our first node
            first = node;
        }
        
        // update last to be curr node
        last = node;
        
        // right
        helper(node.right);
    }
}