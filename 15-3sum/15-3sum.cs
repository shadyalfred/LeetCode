public class Solution
{
    public IList<IList<int>> ThreeSum(int[] nums)
    {
        Array.Sort(nums);
        
        IList<IList<int>> triplets = new List<IList<int>>();
        
        for (int i = 0; i < nums.Length - 2; i++)
        {
            if (i > 0 && nums[i - 1] == nums[i])
            {
                continue;
            }
            SearchTriplet(nums, i + 1, - nums[i], triplets);
        }
        
        return triplets;
    }
    private void SearchTriplet(
        int[] nums,
        int left,
        int target,
        IList<IList<int>> triplets
    )
    {
        int right = nums.Length - 1;
        
        while (left < right)
        {
            int currentSum =  nums[left] + nums[right];
            
            if (currentSum == target)
            {
                triplets.Add(new List<int>() { - target, nums[left], nums[right] });
                left++;
                right--;
                
                while (left < right && nums[left] == nums[left - 1])
                    left++;
                while (left < right && nums[right] == nums[right + 1])
                    right--;
            }
            else if (currentSum < target)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
    }
}