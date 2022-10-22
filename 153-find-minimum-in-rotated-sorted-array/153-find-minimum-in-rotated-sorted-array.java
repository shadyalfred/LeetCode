class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int min = nums[0];
        
        while (l <= h) {
            if (nums[l] <= nums[h]) {
                return Math.min(min, nums[l]);
            }
            
            int mid = (l + h) / 2;
            
            min = Math.min(min, nums[mid]);
            
            // on the left side
            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            // on the right side
            } else {
                h = mid - 1;
            }
        }
        
        return min;
    }
}