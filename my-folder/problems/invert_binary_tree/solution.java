// Recursive solution
// T: O(n) - we perf constant op on every node
// S: O(n) - stack space used, O(n) if binary tree is completely imbalanced, O(logn) if binary tree is completely balanced
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode leftsub = invertTree(root.left);
        TreeNode rightsub = invertTree(root.right);
        
        root.left = rightsub;
        root.right = leftsub;
        
        return root;
    }
}