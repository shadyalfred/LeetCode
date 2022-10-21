class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        
        while (l <= h) {
            int mid = (l + h) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Left sorted side 
            if (nums[l] <= nums[mid]) {
                //  normal binary search || target lies on the other side
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            } else {
                //  normal binary search || target lies on the other side
                if (target < nums[mid] || target > nums[h]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        
        return -1;
    }
}