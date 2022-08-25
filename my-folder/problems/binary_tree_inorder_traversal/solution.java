class Solution {
    // iterative solution with stack DS
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inList = new LinkedList<>();
        if(root == null) return inList;
        
        Deque<TreeNode> stack = new LinkedList<>();
        
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            inList.add(curr.val);
            curr = curr.right;
        }
        return inList;
    }
}