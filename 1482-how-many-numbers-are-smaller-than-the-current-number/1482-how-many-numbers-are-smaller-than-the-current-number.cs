public class Solution {
  public int[] SmallerNumbersThanCurrent(int[] nums) {
    int[] numsCount = new int[101];
    int[] ans = new int[nums.Length];
    foreach (int num in nums)
    {
      numsCount[num]++;
    }
    for (int i = 0; i < nums.Length; i++)
    {
      int count = 0;
      for (int j = 0; j < nums[i]; j++)
      {
        count += numsCount[j];
      }
      ans[i] = count;
    }
    return ans;
  }
}