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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        
        List<Integer> list = new ArrayList();
        
        if (root == null) {
            return list;
        }
        
        q.add(root);
        
        while (!q.isEmpty()) {
            Queue<TreeNode> tempQ = new LinkedList();
            
            TreeNode lastNode = q.peek();
            
            while (!q.isEmpty()) {
                lastNode = q.poll();
                
                if (lastNode.left != null) {
                    tempQ.add(lastNode.left);
                }
                if (lastNode.right != null) {
                    tempQ.add(lastNode.right);
                }
            }
            
            list.add(lastNode.val);
            
            q = tempQ;
        }
        
        return list;
    }
}