/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // BFS
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        
        pQueue.add(p);
        qQueue.add(q);
        
        while(!pQueue.isEmpty()){
            p = pQueue.poll();
            q = qQueue.poll();
            
            if(!check(p, q)) return false;
            
            if(p != null){
                if(!check(p.left, q.left)) return false;
                if(p.left != null){
                    pQueue.add(p.left);
                    qQueue.add(q.left);
                } 
                
                if(!check(p.right, q.right)) return false;
                if(p.right != null){
                    pQueue.add(p.right);
                    qQueue.add(q.right);
                }
            }
        }
        
        return true;
    }
    
    private boolean check(TreeNode p, TreeNode q){
        // guard against nulls
        if(p == null && q == null) return true;
        // if only p or q is null
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return true;
    }
}