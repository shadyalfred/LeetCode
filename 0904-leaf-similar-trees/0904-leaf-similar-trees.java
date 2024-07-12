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
    private void buildLeafSeq(TreeNode root, List<Integer> leafSeq) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafSeq.add(root.val);
        }

        buildLeafSeq(root.left, leafSeq);
        buildLeafSeq(root.right, leafSeq);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = new ArrayList<>(200);
        List<Integer> leafSeq2 = new ArrayList<>(200);

        buildLeafSeq(root1, leafSeq1);
        buildLeafSeq(root2, leafSeq2);

        if (leafSeq1.size() != leafSeq2.size()) {
            return false;
        }

        for (int i = 0; i < leafSeq1.size(); i++) {
            if (! leafSeq1.get(i).equals(leafSeq2.get(i))) {
                return false;
            }
        }

        return true;
    }
}