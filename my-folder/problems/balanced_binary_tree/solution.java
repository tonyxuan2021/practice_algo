/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    final int M = Integer.MIN_VALUE;
    
    public boolean isBalanced(TreeNode root) {
        // use MIN_VALUE because height of null tree is -1 (generally)
        return checkHeight(root) != M;
    }
    
    // helper fx - recursive
    public int checkHeight(TreeNode root){
    	if(root == null) return -1; // null is true and height of null tree is generally -1 
    
    	int leftH = checkHeight(root.left);
    	if(leftH == M) return M;
        
    	int rightH = checkHeight(root.right);
    	if(rightH == M) return M;
        
    	if(Math.abs(leftH - rightH) > 1) return M;

        // return height of the overall subtree (+1, current leaf node is technically height 0 because null node has height -1)
    	return Math.max(leftH, rightH) + 1;
    }
}