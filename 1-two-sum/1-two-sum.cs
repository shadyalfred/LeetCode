public class Solution
{
  public int[] TwoSum(int[] nums, int target)
  {
    Dictionary<int, int> map = new Dictionary<int, int>();
    
    map[nums[0]] = 0;
    
    for (int i = 1; i < nums.Length; i++)
    {
      if (map.ContainsKey(target - nums[i]))
      {
        return new int[] { map[target - nums[i]], i };
      }
      map[nums[i]] = i;
    }
    
    return new int[] { -1, -1 };
  }
}