// inorder -> left, root, right
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        builder(root, list);
        return list;
    }
    
    private void builder(TreeNode root, List<Integer> list){
        if(root == null) return;
        builder(root.left, list);
        list.add(root.val);
        builder(root.right, list);
    }
}