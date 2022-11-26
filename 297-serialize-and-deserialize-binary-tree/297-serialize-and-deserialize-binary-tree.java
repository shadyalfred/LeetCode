/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        return createTree(vals);
    }
    
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        
        sb.append(root.val);
        sb.append(',');
        
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    
    private int i = 0;
    
    private TreeNode createTree(String[] vals) {
        if (vals[i].equals("N")) {
            this.i++;
            return null;
        }
        
        var root = new TreeNode(Integer.parseInt(vals[i]));
        this.i++;
        
        root.left = createTree(vals);
        root.right = createTree(vals);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));