class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            int complement = target - nums[i];
            if (complements.containsKey(complement)) {
                return new int[] {i, complements.get(complement)};
            } else {
                complements.put(nums[i], i);
            }
        }

        return new int[] {-1, -1};
    }
}