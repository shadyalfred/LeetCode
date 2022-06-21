public class Solution
{
  public bool ContainsDuplicate(int[] nums)
  {
    Dictionary<int, int> freq = new Dictionary<int, int>();
    
    foreach(int num in nums)
    {
      if (freq.ContainsKey(num))
      {
        if (freq[num] == 1)
          return true;
        else
          freq[num]++;
      }
      else
      {
        freq[num] = 1;
      }
    }
    return false;
  }
}