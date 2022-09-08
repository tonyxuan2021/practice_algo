// Iterative solution
// T: O(n)
// S: O(n) for the queue space
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        
        while(!q.isEmpty()){
            // pop off the two nodes
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            
            // if both are null, continue
            if(t1 == null && t2 == null) continue;
            // if only one of them is null, return false
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            
            q.add(t1.left);
            q.add(t2.right);
            
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}