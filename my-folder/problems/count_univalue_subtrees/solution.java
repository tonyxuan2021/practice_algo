/* DFS - Pass Parent Values
univalue subtree if:
1. node has no children (base case)
2. node's children are univalue subtrees AND node and children have same value
T: O(n)
S: O(logn) - height of the tree if we assume it's relatively balanced
*/
public class Solution {
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        is_valid_part(root, 0);
        return count;
    }
    
    // helper fx
    boolean is_valid_part(TreeNode node, int val) {
        // if we are at null, this is a valid subtree
        if(node == null) return true;
        
        // check if node.left and node.right are univalue subtrees 
        // || short circuts but | does not - both sides of the OR get evaluted so we explore ALL possible routes
        if(!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val)) return false;
        
        // if it passed the last step, then this is a valid subtree - increment
        count++;
        
        // at this point, we know this node is a univalue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for parent node
        return node.val == val;
    }
}