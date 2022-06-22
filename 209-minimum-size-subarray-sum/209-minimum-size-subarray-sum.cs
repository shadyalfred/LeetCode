public class Solution
{
    public int MinSubArrayLen(int target, int[] nums)
    {
        int? minimalLength = null;
        
        int sum = 0;
        
        int l = 0;
        for (int r = 0; r < nums.Length; r++)
        {
            sum += nums[r];
            
            while (sum - nums[l] >= target && l <= r)
            {
                sum -= nums[l];
                l++;
            }
            
            if (sum >= target)
            {
                if (minimalLength.HasValue)
                {
                    minimalLength = Math.Min(minimalLength.Value, r - l + 1);
                }
                else
                {
                    minimalLength = r - l + 1;
                }
            }
            
        }
        return minimalLength.HasValue ? minimalLength.Value : 0;
    }
}