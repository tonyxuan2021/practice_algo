// Recursive solution
// T: O(n) - worst case we need to visit every node
// S: O(n) - worst case our stack space requires hitting every node if tree is skewed
class Solution {
    int maxL = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return maxL;
    }
    
    private int getDiameter(TreeNode root){
        // base case
        if(root == null) return 0;
        
        // recursively call down to leaf nodes
        int leftD = getDiameter(root.left);
        int rightD = getDiameter(root.right);
        
        maxL = Math.max(maxL, leftD + rightD);
        
        return Math.max(leftD, rightD) + 1;
    }
}