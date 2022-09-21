// Iterative solution - using two stacks to keep track of node and depth
// T: O(n) - we have to visit every node
// S: O(n) - worst case our stacks contains every node if binary tree is skewed
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        
        nodeStack.push(root);
        depthStack.push(1); // we begin at depth 1
        
        int currDepth = 0, maxDepth = 0;
        
        while(!nodeStack.isEmpty()){
            TreeNode currNode = nodeStack.pop();
            currDepth = depthStack.pop();
            
            if(currNode != null){
                maxDepth = Math.max(maxDepth, currDepth);
                
                nodeStack.push(currNode.left);
                nodeStack.push(currNode.right);
                
                depthStack.push(currDepth + 1);
                depthStack.push(currDepth + 1);
            }
        }
        
        return maxDepth;
    }
}