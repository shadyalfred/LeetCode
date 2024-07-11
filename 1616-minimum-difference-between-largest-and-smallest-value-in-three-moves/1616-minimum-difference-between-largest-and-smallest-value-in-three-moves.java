class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;

        int N = nums.length - 1;

        result = Math.min(result, nums[N - 3] - nums[0]);
        result = Math.min(result, nums[N - 2] - nums[1]);
        result = Math.min(result, nums[N - 1] - nums[2]);
        result = Math.min(result, nums[N] - nums[3]);
        
        return result;
    }
}