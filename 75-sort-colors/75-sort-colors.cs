public class Solution
{
    public void SortColors(int[] nums)
    {
        int low = 0, high = nums.Length - 1;
        
        for (int i = 0; i <= high;)
        {
            if (nums[i] == 0)
            {
                Swap(nums, i, low);
                low++;
                i++;
            }
            else if (nums[i] == 1)
            {
                i++;
            }
            else
            {
                Swap(nums, i, high);
                high--;
            }
        }
    }
    
    private void Swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}