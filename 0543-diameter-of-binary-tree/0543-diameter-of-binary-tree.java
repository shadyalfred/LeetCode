/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int diameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        
        return diameter;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);
        
        diameter = Math.max(diameter, left + right);
        
        return Math.max(left, right);
    }
}