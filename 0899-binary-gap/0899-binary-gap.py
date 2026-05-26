class Solution:
  def binaryGap(self, n: int) -> int:
    n = bin(n)[2:]
    max_gap = 0
    gap = 0
    for c in n:
      if c == '1':
        max_gap = max(max_gap, gap)
        gap = 1
      else:
        gap += 1
    return max_gap