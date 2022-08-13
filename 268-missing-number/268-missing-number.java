class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (j == nums.length) {
                i++;
                continue;
            }
            if (nums[i] != nums[j]) {
                swap(i, j, nums);
            } else {
                i++;
            }
        }
        
        for (int l = 0; l < nums.length; l++) {
            if (nums[l] != l) {
                return l;
            }
        }
        
        return nums.length;
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}