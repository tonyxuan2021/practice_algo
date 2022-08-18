class Solution {
    // Top-down solution: pre-order => root, left, right
    // We go from the root (starting from 1) to the leaves (past it when we hit null that is our base case)
    private int maxDepth = 0;
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return maxDepth(root, 1); // pass along 1 as our root value
    }
    
    public int maxDepth(TreeNode node, int depth){
        if(node == null) return 0;
        // if we are at a leaf node
        if(node.left == null && node.right == null) maxDepth = Math.max(maxDepth, depth);
        // recursively traverse down left and right subtrees and adding 1 to depth at each child level
        maxDepth(node.left, (depth + 1));
        maxDepth(node.right, (depth + 1));
        
        return maxDepth;
    }
    
}