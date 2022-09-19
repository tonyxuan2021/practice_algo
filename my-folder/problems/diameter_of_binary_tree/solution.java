class Solution {
    private int longestDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return longestDiameter;
    }
    
    private int getDiameter(TreeNode node){
        if(node == null) return 0;
        
        int leftD = getDiameter(node.left);
        int rightD = getDiameter(node.right);
        
        longestDiameter = Math.max(longestDiameter, leftD + rightD);
        
        return Math.max(leftD, rightD) + 1;
    }
}