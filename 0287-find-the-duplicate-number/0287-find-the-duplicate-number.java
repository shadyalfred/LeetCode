class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        boolean isFirst = true;

        while (isFirst || slow != fast) {
            if (isFirst) isFirst = false;
            slow = nums[slow];
            fast = nums[nums[fast]];

        }

        int slow2 = nums[0];
        
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
