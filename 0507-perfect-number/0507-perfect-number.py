class Solution:
  def checkPerfectNumber(self, num: int) -> bool:
    n = 0
    for d in range(1, num):
      if d * d > num:
        break

      if num % d == 0:
        n += d
        if d * d != num:
          n += num // d

    return n - num == num