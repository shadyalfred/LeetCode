public class Solution
{
    public int ThreeSumClosest(int[] nums, int target)
    {
        
        Array.Sort(nums);
        
        int smallestDiff = int.MaxValue;
        
        for (int i = 0; i < nums.Length - 2; i++)
        {
            int l = i + 1;
            int r = nums.Length - 1;
            while (l < r)
            {
                int diff = target - nums[i] - nums[l] - nums[r];
                
                if (diff == 0)
                {
                    return target;
                }
                
                if (Math.Abs(diff) < Math.Abs(smallestDiff))
                    smallestDiff = diff;
                
                if (diff > 0)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        
        return target - smallestDiff;
    }
}