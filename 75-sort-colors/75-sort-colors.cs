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
                //int temp = nums[i];
                //nums[i] = nums[low];
                //nums[low] = temp;
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
                //int temp = nums[i];
                //nums[i] = nums[high];
                //nums[high] = temp;
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