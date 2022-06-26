public class Solution
{
    public int NumSubarrayProductLessThanK(int[] nums, int k)
    {
        if (k <= 1) return 0;

        int product = 1, ans = 0, left = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            product *= nums[i];
            
            int r = i + 1;
            while (product >= k)
            {
                product /= nums[left++];
            }
            ans += i - left + 1;
        }
        return ans;
    }
}