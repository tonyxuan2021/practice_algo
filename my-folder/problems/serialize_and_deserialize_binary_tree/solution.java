// T: O(n) becuase we have to perform constant operation on every node
// S: O(n) in the worst case we will have a completely imbalanced binary tree and our recursion stack will take up n space
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode node, StringBuilder sb){
        if(node == null) sb.append("X").append(",");
        else{
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Use a Queue interface so we can poll() from our front (build our binary tree preorder)
        Queue<String> nodesQ = new LinkedList<>();
        // convert our String into a List so we can add it to our queue
        nodesQ.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodesQ);
    }
    
    private TreeNode buildTree(Queue<String> nodesQ){
        // poll from our queue
        String currNode = nodesQ.poll();
        
        if(currNode.equals("X")) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(currNode));
            // follow the same preorder traversal
            node.left = buildTree(nodesQ);
            node.right = buildTree(nodesQ);
            return node;
        }
    }
}
