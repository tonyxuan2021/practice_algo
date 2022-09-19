class Solution {
    // variable to keep track of our binary tree is balanced
    private boolean balancedBool = true;
    
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balancedBool;
    }
    
    private int getHeight(TreeNode node){
        // base case
        if(node == null) return -1;
        
        // recursively go down our tree (to the leaf nodes and beyond)
        int leftSub = getHeight(node.left);
        int rightSub = getHeight(node.right);
        
        // check if node is balanced
        if(Math.abs(leftSub - rightSub) > 1) balancedBool = false;
        
        return Math.max(leftSub, rightSub) +1;
        
    }
}