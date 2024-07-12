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
    int low;
    int high;
    int sum = 0;

    void sum(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val > high) {
            sum(root.left);
        } else if (root.val < low) {
            sum(root.right);
        } else {
            sum += root.val;
            sum(root.left);
            sum(root.right);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;

        sum(root);
        return sum;
    }
}