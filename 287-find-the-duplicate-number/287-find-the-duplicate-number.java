class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            } else {
                i++;
            }
        }
        
        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return nums[i];
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