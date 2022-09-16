// iterative using parent pointers
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parentHM = new HashMap<>();
        
        parentHM.put(root, null);
        stack.push(root);
        
        // iterate until we find both p and q nodes
        while(!parentHM.containsKey(p) || !parentHM.containsKey(q)){
            TreeNode node = stack.pop();
            // save parent pointers as we traverse tree
            if(node.left != null){
                parentHM.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null){
                parentHM.put(node.right, node);
                stack.push(node.right);
            }
        }
        
        // Ancestors set() for node p
        Set<TreeNode> ancestors = new HashSet<>();
        
        // *** don't fully understand this part
        // ancestors of p (5) which is 5 and 3... I think..
        // p becomes null when we get ancestor of 3
        // Process all ancestors for node p using parent pters
        while(p != null){ //*** when will p be null?
            ancestors.add(p);
            p = parentHM.get(p);
        }
        
        // First ancestor in q that appears in p's set() is LCA
        while(!ancestors.contains(q)){
            q = parentHM.get(q);
        }
        
        return q;
    }
}
/*
If we have parent pointers for each node we can traverse back from p and q. First common nose we get during traversal will be LCA node. We save parent pointers in a dictionary as we traverse the tree.

Algo:
1. start from root and traverse
2. until we find p and q, store parent pointers in a dictionary
3. once we found p and q, we get all ancestors for p using parent dictionary and add to a set called ancestors.
4. similarly, we traverse through ancestors for q. If ancestor is present in ancestors set for p, this means this is the first ancestor common b/ween p and q (traversing upwards) and hence this is LCA node.
*/

