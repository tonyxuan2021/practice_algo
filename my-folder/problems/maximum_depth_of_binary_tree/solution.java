// BFS
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxD = 0;
        
        // BFS use Queue interface
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            maxD++;
        }
        return maxD;
    }
}