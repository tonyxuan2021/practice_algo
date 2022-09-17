// T: O(n) - have to op on every node
// S: O(n) - leaf node has n/2 for our largest queue space 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            // first identify leftsub so we do not switch back and forth and return back to original
            TreeNode leftsub = currNode.left;
            
            currNode.left = currNode.right;
            currNode.right = leftsub;
            
            if(currNode.left != null) queue.add(currNode.left);
            if(currNode.right != null) queue.add(currNode.right);
        }
        
        return root;
    }
}