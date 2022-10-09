class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[nums.length];
        
        
        for (int i = 0; i < n; i++) {
            shuffled[i * 2] = nums[i];
            shuffled[(i * 2) + 1] = nums[i + n];
        }
        
        return shuffled;
    }
}