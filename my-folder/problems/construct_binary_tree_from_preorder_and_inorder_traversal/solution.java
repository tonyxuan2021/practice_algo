// T: O(n) - hashmap takes O(n) time to add up n nodes. Adding costs O(1). Building tree takes O(n), recursive helper cost sO(1) for each call.
// S: O(n) - building hashmap and storing entire tree requires O(n). Size of implicit stack used by recursion call depends on height of tree which is O(n) in worst case and O(logn) on average.
class Solution {
    int preorder_rootidx;
    Map<Integer, Integer> inorderHM = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorder_rootidx = 0;
        
        // build our hashmap so we can have index to divide our list to left and right subtree
        // T: O(n) to build hashmap
        // S: O(n) to store the hashmap
        for(int i = 0; i < inorder.length; i++){
            inorderHM.put(inorder[i], i); // T: O(1) 
        }
        
        return helper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int in_left, int in_right){
        if(in_left > in_right) return null;
        
        // get the root value and build our root
        int rootval = preorder[preorder_rootidx++];
        // T: O(n) => building binary tree by adding root one at a time takes O(1 * n nodes)
        TreeNode root = new TreeNode(rootval);
        
        // get the index of where the root is from inorder list
        int inorder_rootidx = inorderHM.get(rootval); // HM.get() returns value
        
        // recursively call helper on left subtree then right subtree because preorder is root, left, right
        // S: O(n) call stack if tree is completely unbalanced, O(logn) if tree is completely balanced
        root.left = helper(preorder, in_left, inorder_rootidx - 1);
        root.right = helper(preorder, inorder_rootidx + 1, in_right);
        
        return root;
    }
}