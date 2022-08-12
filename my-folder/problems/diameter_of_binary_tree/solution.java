/* 
Diameter of binary tree is length of longest path between any two nodes in a tree 
and length is number of edges between them.
Algo: Dive into leaves first and count the edges upwards (via recursion) because the longest length is between two leaf nodes.
*/
// T: O(n) - enter and exit from each node once
// S: O(n) - depends on size of call stack which relates to height of the tree 
    // worst case, the tree is skewed so height of the tree is O(n)
    // if the tree is balanced, it will be O(log n)
class Solution {
    private int longestDiameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        longestDiameter = 0;
        findLongestPath(root); // this updates longestDiameter
        return longestDiameter;
    }
    
    // recursive fx from leaf node up
    private int findLongestPath(TreeNode root){
        if(root == null) return 0; // null roots have path of 0
        
        int leftPath = findLongestPath(root.left);
        int rightPath = findLongestPath(root.right);
        
        longestDiameter = Math.max(longestDiameter, leftPath + rightPath);
        
        return Math.max(leftPath, rightPath) + 1;
    }

}