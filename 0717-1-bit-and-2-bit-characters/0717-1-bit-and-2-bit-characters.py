class Solution:
  def isOneBitCharacter(self, bits: List[int]) -> bool:
    i = 0
    is_one = False
    while i < len(bits):
      if bits[i] == 1:
        i += 2
        is_one = False
      else:
        i += 1
        is_one = True
    return is_one