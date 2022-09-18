// Iterative approach
// T: O(n) - we have to operate on every node in worst case
// S: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        
        while(true){
            if(p.val > root.val && q.val > root.val) root = root.right;
            else if (p.val < root.val && q.val < root.val) root = root.left;
            else return root;
        }
    }
}