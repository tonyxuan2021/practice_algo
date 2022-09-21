// Recursive solution
// T: O(n) - we need to perform constant calc in every node
// S: O(n) - worst case is if binary tree is skewed on our recursion stack
class Solution {
    boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balanced;
    }
    
    private int getHeight(TreeNode node){
        // base case
        if(node == null) return -1;
        
        // recursively go down to the leaf node
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        if(Math.abs(leftHeight - rightHeight) > 1) balanced = false;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}