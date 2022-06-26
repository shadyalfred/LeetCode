public class Solution
{
    public void SortColors(int[] nums)
    {
        int low = 0, high = nums.Length - 1;
        
        for (int i = 0; i <= high;)
        {
            if (nums[i] == 0)
            {
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                low++;
                i++;
            }
            else if (nums[i] == 1)
            {
                i++;
            }
            else
            {
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}