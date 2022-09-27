// Iterative solution
// T: O(n) - need to process every node
// S: O(n) - last level (leaf nodes) there are n/2 or n in our queue
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(!check(p, q)) return false;
        
        // queues
        Queue<TreeNode> queueP = new ArrayDeque<>();
        Queue<TreeNode> queueQ = new ArrayDeque<>();
        queueP.add(p);
        queueQ.add(q);
        
        while(!queueP.isEmpty()){
            p = queueP.poll();
            q = queueQ.poll();
            
            if(!check(p, q)) return false;
            
            if(p != null){
                if(!check(p.left, q.left)) return false;
                if(p.left != null){
                    queueP.add(p.left);
                    queueQ.add(q.left);
                }
                
                if(!check(p.right, q.right)) return false;
                if(p.right != null){
                    queueP.add(p.right);
                    queueQ.add(q.right);
                }
            }
        }
        
        return true;
    }
    
    private boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return true;
    }
}