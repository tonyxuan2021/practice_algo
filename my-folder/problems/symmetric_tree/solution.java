// recursion
// T: O(n) because we touch every node once and perf constant calc on each
// S: O(logn) this is the height of our binary tree 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true; 
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right){
        // base case: check if both are null
        if(left == null || right == null) return left == right;
        // base case: check if left and right values are the same
        if(left.val != right.val) return false;
        
        // recursion 
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}