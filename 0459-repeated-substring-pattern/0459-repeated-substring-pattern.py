class Solution:
  def repeatedSubstringPattern(self, s: str) -> bool:
    n = len(s) // 2 + 1
    for i in range(1, n):
      j = i
      sub = s[:i]
      is_good = True
      while j < len(s):
        if sub != s[j:j+i]:
          is_good = False
          break
        j += i

      if is_good:
        return True

    return False
        