// inorder -> left, root, right
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inlist = new LinkedList<>();
        if(root == null) return inlist;
            
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()){
            // travel to left most node
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            // pop off our stack and add to our inlist
            curr = stack.pop();
            inlist.add(curr.val);
            curr = curr.right;
        }
        return inlist;
    }
}