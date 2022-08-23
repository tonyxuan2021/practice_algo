// T: O(n) - because we touch every node once
// S: O(logn) - height of the binary tree 
// root node to leaf node 
class Solution {
    // recursive solution
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        else if(root.left == null && root.right == null && root.val == targetSum) return true;
        
        // recursion
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}