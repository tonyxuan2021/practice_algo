class Solution {
    Node prev;
    Node leftMost;
    
    public Node connect(Node root) {
        if(root == null) return null;
        leftMost = root; // initially our root is leftMost (only node at level 0)

        // outer while-loop to loop through every level in our tree
        while(leftMost != null){
            prev = null; // initially set prev as null
            Node curr = leftMost;
            leftMost = prev; // reset leftMost
            
            // inner while-loop to loop through every node in curr level
            while(curr != null){
                helper(curr.left);
                helper(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }
    
    private void helper(Node childNode){
        if(childNode != null){
            if(prev != null) prev.next = childNode;
            // else we are at leftMost node
            else leftMost = childNode;
            
            // move prev along
            prev = childNode;
        }
    }
}