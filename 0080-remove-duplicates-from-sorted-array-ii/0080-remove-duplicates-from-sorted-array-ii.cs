public class Solution {
    public int RemoveDuplicates(int[] nums) {
        int count = 0;
        for (int l = 1; l < nums.Length; l++) {
            if (nums[l] == nums[l - 1]) {
                int r = l + 1;
                while (r < nums.Length - count && nums[r] == nums[l]) {
                    r++;
                }
                if (r != l + 1) {
                    int oldCount = count;
                    count += r - l - 1;
                    Shrink(l + 1, r, oldCount, nums);
                }
            }
        }
        return nums.Length - count;
    }

    private void Shrink(int l, int r, int count, int[] nums) {
        for (int i = 0; r + i < nums.Length - count; i++) {
            nums[l + i] = nums[r + i];
        }
    }
}