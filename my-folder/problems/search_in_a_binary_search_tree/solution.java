// Recursive solution
// T: O(n) - worst case our value is a leaf node and tree is skewed
// S: O(n) - worst case our value is a leaf node and tree is skewed
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        
        // BST properties
        
        // if our root > val, we search left
        if(root.val > val) return searchBST(root.left, val);
        // if our root < val, we search right
        if(root.val < val) return searchBST(root.right, val);
        // if we cannot find val, we return null
        return null;
    }
}