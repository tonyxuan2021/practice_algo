// Recursive solution
// T: O(n) - we need to visit each node once
// S: O(n) - worst case the tree is skewed so we need O(n) stack space
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    // helper fx
    private void inorderHelper(TreeNode node, List<Integer> result){
        // recursion
        // base case:
        if(node == null) return;
        
        // inorder -> left, root, right
        // left:
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);    
    }
}