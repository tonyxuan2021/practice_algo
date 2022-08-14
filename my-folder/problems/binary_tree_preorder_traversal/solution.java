class Solution {
    // preorder => root, left, right
    // iterative solution with stack
    public List<Integer> preorderTraversal(TreeNode root) {
        // List for our return and Deque for our stack DS
        List<Integer> preList = new LinkedList<>();
        if(root == null) return preList;
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            // pop off our stack and add to our List
            TreeNode currNode = stack.pop();
            preList.add(currNode.val);
            
            if(currNode.right != null) stack.push(currNode.right);
            if(currNode.left != null) stack.push(currNode.left);
        }
        
        return preList;
    }
}