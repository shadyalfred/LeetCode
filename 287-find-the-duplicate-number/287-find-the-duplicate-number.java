class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                } else {
                    swap(i, nums[i] - 1, nums);
                }
            } else {
                i++;
            }
        }
        
        return -1;
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}