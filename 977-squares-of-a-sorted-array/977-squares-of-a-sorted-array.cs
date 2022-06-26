public class Solution
{
    public int[] SortedSquares(int[] nums)
    {
        int highestIndex = nums.Length - 1;
        
        int[] squares = new int[nums.Length];
        
        int l = 0, r = nums.Length - 1;
        
        while (l <= r)
        {
            if (Math.Abs(nums[r]) > Math.Abs(nums[l]))
            {
                squares[highestIndex] = nums[r] * nums[r];
                r--;
            }
            else
            {
                squares[highestIndex] = nums[l] * nums[l];
                l++;
            }
            highestIndex--;
        }
        
        return squares;
    }
}