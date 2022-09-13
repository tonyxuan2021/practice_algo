// This solution requires a queue becasue we don't know the structure of the tree and kind of branches it has. And we need to access all the nodes on a common level together.
// 
class Solution {
    Node prev, leftmost;
    
    // main fx
    public Node connect(Node root) {
        if(root == null) return null;
        
        // the root node is the only node on first level, hence leftmost
        this.leftmost = root;
        
        // we don't have an idea of tree structure, so we keep going until we find the last level
        while(this.leftmost != null){
            // prev tracks the latest node on the next level
            // curr tracks the latest node on the current level
            this.prev = null;
            Node curr = this.leftmost;
            
            // we reset this so we can re-assign it to leftmost node on next level. Also, if there isn't one, this would help break us out of outer loop.
            this.leftmost = null;
            
            // iterate on the nodes in curr level using next pters
            while(curr != null){
                // process both children and update the prev and leftmost pters 
                this.processChild(curr.left);
                this.processChild(curr.right);
                
                // move onto the next node
                curr = curr.next;
            }
        }
        return root;
    }
    
    // helper fx
    public void processChild(Node childNode){
        if(childNode != null){
            // If the prev pointer is already set, i.e. we already found at least one node on the next level, set-up its next pointer
            if(this.prev != null) this.prev.next = childNode;
            // else this means child node is the first node we have encountered on the next level, so we set the leftmost pointer
            else this.leftmost = childNode;
            
            this.prev = childNode;
        }
    }
}

/*
Algo:
1. start at root node, then establish next pointers on next level.
2. we go over nodes of a specific level (pointers already established). TO start on a particular level, we just need leftmost node.
3. 
4. 
i) leftmost - head of our LL (since structure of tree can be anything), we don't really know what the leftmost node on a level would be
ii) curr - current node
iii) prev - pointer to the leading node on next level. We need this pointer because whenever we update the curr node, we assign prev.next to left child of curr (if one exist) otherwise right child. 
updating prev (4 scenarios):
    1) prev is assigned to non-null value (initialized). We start with null then when we find the FIRST node on the NEXT level, we assign leftmost child to prev
    2) when node on curr level doesn't have left child. We then point prev to the RIGHT child of curr node. 
    3) node with no child - we DON'T update the prev pointer
    4) node with 2 children, we first update prev to left child and once processed, we update prev to right child
5. Once we are done with curr level, we move on to next level. We update leftmost node. We do this by prev pointer, whenever we set the value for prev pointer for the first time, we also set the head or leftmost to that node. 
*/