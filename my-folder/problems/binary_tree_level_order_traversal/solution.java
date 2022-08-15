// Given the root of a binary tree, return the level order traversal of its nodes' values 
// i.e. BFS - root, child left, child right
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        // BFS - queue DS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); 
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currLevel = new LinkedList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
            result.add(currLevel);
        }
        return result;
    }
}