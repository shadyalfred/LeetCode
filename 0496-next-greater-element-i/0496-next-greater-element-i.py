class Solution:
  def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
    ans = []

    index_of = dict()
    for i, num in enumerate(nums2):
      index_of[num] = i + 1
    
    for num in nums1:
      i = index_of.get(num) or -1
      if i == -1:
        ans.append(i)
        continue
      
      was_found = False
      while i < len(nums2):
        if nums2[i] >= num:
          was_found = True
          ans.append(nums2[i])
          break
        i += 1
        
      if not was_found:
        ans.append(-1)
    
    return ans


