// Approach 2: Iterative Inorder Traversal
// inorder - left, root, right for BST (arr in ASC)
// answer is k - 1
// T: O(n)
// S: O(n) - to keep inorder traversal
// idx:   0  1  2  3
// nums: [1, 2, 3, 4]
class Solution {        
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}