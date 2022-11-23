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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        
        List<List<Integer>> list = new ArrayList();
        
        if (root == null) {
            return list;
        }
        
        q.add(root);
        
        while (!q.isEmpty()) {
            var level = new ArrayList<Integer>();
            
            Queue<TreeNode> tempQ = new LinkedList();
            
            while (!q.isEmpty()) {
                var node = q.poll();
                
                level.add(node.val);
                
                if (node.left != null) {
                    tempQ.add(node.left);
                }
                
                if (node.right != null) {
                    tempQ.add(node.right);
                }
            }
            
            list.add(level);
            
            q = tempQ;
        }
        
        return list;
    }
}