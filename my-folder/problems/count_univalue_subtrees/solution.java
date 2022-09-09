class Solution {
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return count;
        helper(root);
        return count;
    }
    
    private boolean helper(TreeNode node){
        if(node == null) return true; 
        
        // recursively traverse 
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        
        if((left && right) &&
           (node.left == null || node.val == node.left.val) &&
           (node.right == null || node.val == node.right.val)
        ){
            count++;
            return true;
        }
        
        else return false;
    }
}