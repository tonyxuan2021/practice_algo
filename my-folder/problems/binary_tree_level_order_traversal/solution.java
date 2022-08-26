class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        // use Queue interface to perform BFS traversal iteratively
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            // get the size of our queue for our for-loop operation
            int size = queue.size();
            // create a new ArrayList for each level
            List<Integer> currLevel = new ArrayList<>();
            
            // for-loop to add elements in our queue to our currLevel
            for(int i = 0; i < size; i++){
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                
                // add currNode's children to our queue for next while-loop iteration
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
            result.add(currLevel);
        }
        return result;
    }
}