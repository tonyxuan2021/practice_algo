// inorder => left, root, right
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        
        Deque<TreeNode> stack = new LinkedList<>();
        
        while(root != null || !stack.isEmpty()){
            // we traverse all the way to the left
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            // when we reached the very left node in our binary tree
            root = stack.pop();
            result.add(root.val); // result adds left, root -> now we are just missing right
            root = root.right;
        }
        
        
        return result;
    }
}