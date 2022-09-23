// Approach 2: Iterative Traversal with Valid Range
// Recursion can be converted into iteration with stack (DFS used here because it works faster than BFS in this example)
// Time complexity: O(N) since we visit each node exactly once.
// Space complexity: O(N) since we keep up to the entire tree.
class Solution {
    private Deque<TreeNode> stack = new LinkedList<>();
    private Deque<Integer> upperLimits = new LinkedList<>();
    private Deque<Integer> lowerLimits = new LinkedList<>();
    
    public boolean isValidBST(TreeNode root) {
        Integer low = null, high = null, val;
        update(root, low, high);
        
        while(!stack.isEmpty()){
            root = stack.poll(); // remove from front of LL
            low = lowerLimits.poll();
            high = upperLimits.poll();
            
            if(root == null) continue;
            
            if(low != null && root.val <= low) return false;
            if(high != null && root.val >= high) return false;
            
            update(root.right, root.val, high);
            update(root.left, low, root.val);
        }
        
        return true;
    }
    
    private void update(TreeNode root, Integer low, Integer high){
        if(root == null) return;
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }
}