class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;

        int N = nums.length - 1;

        for (int i = 0; i < 4; i++) {
            result = Math.min(result, nums[nums.length - 4 + i] - nums[i]);
        }

        return result;
    }
}