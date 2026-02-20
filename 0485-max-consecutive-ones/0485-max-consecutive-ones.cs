public class Solution {
  public int FindMaxConsecutiveOnes(int[] nums) {
    int maxRun = 0;
    int run = 0;
    for (int i = 0; i < nums.Length; i++)
    {
      if (nums[i] == 1)
      {
        run++;
      }
      else
      {
        maxRun = Math.Max(maxRun, run);
        run = 0;
      }
    }
    return Math.Max(maxRun, run);
  }
}