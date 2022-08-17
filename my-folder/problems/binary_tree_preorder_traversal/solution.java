// preorder - root, left, right
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> prelist = new LinkedList<>();
        if(root == null) return prelist;
        
        // stack DS 
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            prelist.add(curr.val);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        return prelist;
    }
}