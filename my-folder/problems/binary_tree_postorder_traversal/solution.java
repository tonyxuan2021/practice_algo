// postorder -> left, right, root
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postlist = new LinkedList<>();
        if(root == null) return postlist;
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            postlist.add(0, curr.val);
            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        
        return postlist;
    }
}