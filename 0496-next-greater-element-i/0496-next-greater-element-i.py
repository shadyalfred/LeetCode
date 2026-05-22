class Solution:
  def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
    stack = []
    next_greater_element = dict()

    for num in nums2[::-1]:
      while stack and stack[-1] <= num:
        stack.pop()
      next_greater_element[num] = stack[-1] if stack else -1
      stack.append(num)
    
    return [next_greater_element[num] for num in nums1]