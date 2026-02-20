public class Solution {
  public int[] FindErrorNums(int[] nums) {
    int[] ans = new int[2];
    bool[] numbers = new bool[nums.Length + 1];
    for (int i = 0; i < nums.Length; i++)
    {
      if (numbers[nums[i]])
      {
        ans[0] = nums[i];
      }
      numbers[nums[i]] = true;
    }
    for (int i = 1; i < numbers.Length; i++)
    {
      if (!numbers[i])
      {
        ans[1] = i;
        break;
      }
    }
    return ans;
  }
}