# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
  def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
    def dfs(root: Optional[TreeNode], is_left: bool) -> int:
      if root is None:
        return 0

      if is_left and root.left is None and root.right is None:
        return root.val
      
      return dfs(root.left, True) + dfs(root.right, False)
    return dfs(root, False)
        