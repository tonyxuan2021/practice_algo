// Max Depth - number of nodes along LONGEST path from root node down to farthest leaf nodes
class Solution {
    // Approach 3: Iterative approach
    // stack DS, one can mimic behaviors of fx call stack involved in recursion 
    public int maxDepth(TreeNode root) {
        // two stacks to track nodes and depth
        Deque<TreeNode> nodeS = new LinkedList<>();
        Deque<Integer> depthS = new LinkedList<>();
        
        int currDepth = 0, maxDepth = 0;
        
        nodeS.push(root);
        depthS.push(1);
        
        if(root == null) return 0;
        
        while(!nodeS.isEmpty()){
            root = nodeS.pop();
            currDepth = depthS.pop();
            
            if(root != null){
                nodeS.push(root.left);
                nodeS.push(root.right);
                
                maxDepth = Math.max(maxDepth, currDepth);
                
                depthS.push(currDepth + 1);
                depthS.push(currDepth + 1);
            }
        }
        
        return maxDepth;
    }
}
