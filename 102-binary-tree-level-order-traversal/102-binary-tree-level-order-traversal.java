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
        
        q.add(root);
        
        while (q.peek() != null) {
            var level = new ArrayList<Integer>();
            
            Queue<TreeNode> tempQ = new LinkedList();
            
            while (q.peek() != null) {
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