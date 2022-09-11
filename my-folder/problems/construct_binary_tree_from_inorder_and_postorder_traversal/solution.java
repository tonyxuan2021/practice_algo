class Solution {
    int[] inorder;
    int[] postorder;
    
    int postorder_rootIdx;
    HashMap<Integer, Integer> inorderHM = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        
        // build hashmap from inorder list for our helper left and right boundaries
        int idx = 0;
        for(int value : inorder){
            inorderHM.put(value, idx++);
        }
        
        postorder_rootIdx = postorder.length - 1;
        
        return helper(0, postorder.length - 1);
    }
    
    private TreeNode helper(int in_left, int in_right){
        if(in_left > in_right) return null;
        
        // get root value and create new TreeNode root
        int rootval = postorder[postorder_rootIdx];
        TreeNode root = new TreeNode(rootval);
        
        // get the index of rootval in our inorder list so we can split to left and right subtree
        int inorder_rootidx = inorderHM.get(rootval);
        // decrement our postorder_rootidx because postorder is left, right, root
        postorder_rootIdx--;
        
        // recrusively call right and left subtree 
        root.right = helper(inorder_rootidx + 1, in_right);
        root.left = helper(in_left, inorder_rootidx - 1);
        
        return root;
    }
}