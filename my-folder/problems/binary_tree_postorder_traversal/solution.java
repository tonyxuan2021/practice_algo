class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postList = new LinkedList<>();
        if(root == null) return postList;
        
        // use stack DS to traverse through binary tree iteratively
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            // add node to the front of our list
            postList.add(0, curr.val);
            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        return postList;
    }
}