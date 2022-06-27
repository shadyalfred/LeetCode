public class Solution
{
    public int FindUnsortedSubarray(int[] nums)
    {
        int left = 0;
        int right = nums.Length - 1;
        
        while (left < nums.Length - 1 && nums[left] <= nums[left + 1])
        {
            left++;
        }
        
        if (left == nums.Length - 1)
        {
            return 0;
        }
        
        while (right > 0 && nums[right] >= nums[right - 1])
        {
            right--;
        }
        
        int maxWindow = int.MinValue;
        int minWindow = int.MaxValue;
        
        for (int i = left; i <= right; i++)
        {
            maxWindow = Math.Max(maxWindow, nums[i]);
            minWindow = Math.Min(minWindow, nums[i]);
        }
        
        while (left > 0 && nums[left - 1] > minWindow)
        {
            left--;
        }
        
        while (right < nums.Length - 1 && nums[right + 1] < maxWindow)
        {
            right++;
        }
        
        return right - left + 1;
    }
}