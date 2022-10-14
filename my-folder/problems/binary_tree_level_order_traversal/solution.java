
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null) return levels;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int level = 0; // initialize level at 0
        
        while(!queue.isEmpty()){
            // create a new level each time we exist inner for-loop
            levels.add(new ArrayList<Integer>());
            
            int length = queue.size();
            
            for(int i = 0; i < length; i++){
                TreeNode node = queue.poll();
                levels.get(level).add(node.val);
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            level++;
        }
        
        
        return levels;
    }
}