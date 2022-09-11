class Solution {
    int preorder_rootidx;
    HashMap<Integer, Integer> inorderHM = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorder_rootidx = 0;
        
        // build our hashmap so we can have index to divide our list to left and right subtree
        for(int i = 0; i < inorder.length; i++){
            inorderHM.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int in_left, int in_right){
        if(in_left > in_right) return null;
        
        // get the root value and build our root
        int rootval = preorder[preorder_rootidx++];
        TreeNode root = new TreeNode(rootval);
        
        // get the index of where the root is from inorder list
        int inorder_rootidx = inorderHM.get(rootval); // get returns value
        
        // recursively call helper on left subtree then right subtree
        root.left = helper(preorder, in_left, inorder_rootidx - 1);
        root.right = helper(preorder, inorder_rootidx + 1, in_right);
        
        return root;
    }
}