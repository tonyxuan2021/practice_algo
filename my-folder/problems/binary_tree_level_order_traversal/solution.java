// Iterative solution - BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null) return levels;
        
        // use Queue interface for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int level = 0; // start at level 0

        while(!queue.isEmpty()){
            // create new level inside levels
            levels.add(new ArrayList<Integer>());
            
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode currNode = queue.poll();
                levels.get(level).add(currNode.val);
                
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
            
            level++;
        }
        
        return levels;
    }
}