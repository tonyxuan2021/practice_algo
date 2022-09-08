class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        // use two stack interfaces 
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        
        nodeStack.push(root);
        sumStack.push(targetSum - root.val);
        
        TreeNode currNode;
        int sumLeftover;
        
        while(!nodeStack.isEmpty()){
            currNode = nodeStack.pop();
            sumLeftover = sumStack.pop();
            
            // if we're at a leaf node
            if(currNode.left == null && currNode.right == null && sumLeftover == 0) return true;
            
            // if we're not at a leaf node
            if(currNode.left != null){
                nodeStack.push(currNode.left);
                sumStack.push(sumLeftover - currNode.left.val);
            }
            if(currNode.right != null){
                nodeStack.push(currNode.right);
                sumStack.push(sumLeftover - currNode.right.val);
            }
        }
        return false;
    }
}