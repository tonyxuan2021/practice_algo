// postorder -> left, right, root
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        builder(root, list);
        return list;
    }
    
    private void builder(TreeNode root, List<Integer> list){
        if(root == null) return;
        builder(root.left, list);
        builder(root.right, list);
        list.add(root.val);
    }
}