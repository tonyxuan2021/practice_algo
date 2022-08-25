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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preList = new LinkedList<>();
        preListBuilder(root, preList); // use helper fx so we do not have to create a new List<Integer> everytime
        return preList;
    }
    
    // recursive solution
    private void preListBuilder(TreeNode node, List<Integer> preList){
        if(node == null) return; // base case
        preList.add(node.val);
        preListBuilder(node.left, preList);
        preListBuilder(node.right, preList);
    }
}