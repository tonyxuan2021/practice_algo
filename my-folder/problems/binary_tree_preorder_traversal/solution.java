// preorder - root, left, right
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        builder(root, list);
        return list;
    }
    
    private void builder(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        builder(root.left, list);
        builder(root.right, list);
    }
}