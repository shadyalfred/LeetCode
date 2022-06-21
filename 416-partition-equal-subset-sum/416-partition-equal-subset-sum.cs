public class Solution
{
  public bool CanPartition(int[] nums)
  {
    if (nums.Length == 0)
    {
      return true;
    }

    int totalSum = 0;
    foreach (int num in nums)
    {
      totalSum += num;
    }
    
    if (totalSum % 2 != 0)
    {
      return false;
    }
    
    bool[] canReach = new bool[totalSum / 2 + 1];
    
    canReach[0] = true;
    
    foreach (int num in nums)
    {
      for (int amount = totalSum / 2; amount >= num; amount--)
      {
        canReach[amount] |= canReach[amount - num];
      }
    }
    
    return canReach[totalSum / 2];
  }
}