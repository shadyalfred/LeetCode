/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public string serialize(TreeNode root) {
        StringBuilder sb = new();
        
        if (root == null)
            return sb.ToString();
        
        String leftSubtree = serialize(root.left);
        String rightSubtree = serialize(root.right);
        
        sb.Append($"({root.val},{leftSubtree.Length},{rightSubtree.Length})");
        sb.Append(leftSubtree);
        sb.Append(rightSubtree);
        
        return sb.ToString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data) {
        if (string.IsNullOrEmpty(data))
            return null;
        
        int index = data.IndexOf(')');
        string[] rootValues = data[1..index].Split(",");
        
        TreeNode root = new TreeNode(int.Parse(rootValues[0]));
        
        int leftStringLen = int.Parse(rootValues[1]);
        root.left = deserialize(data[(index + 1)..(index + 1 + leftStringLen)]);
        
        
        int rightStringLen = int.Parse(rootValues[2]);
        root.right = deserialize(data[(index + leftStringLen + 1)..(index + 1 + leftStringLen + rightStringLen)]);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));