// Approach 4: Recursive DFS
// traverse tree level by level, starting each time from rightmost child
class Solution {
    List<Integer> rightside = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return rightside;
        helper(root, 0);
        return rightside;
    }
    
    public void helper(TreeNode node, int level){
        if(level == rightside.size()) rightside.add(node.val);
        
        if(node.right != null) helper(node.right, level + 1);
        if(node.left != null) helper(node.left, level + 1);
    }
}