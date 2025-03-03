class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];

        int l = 0, r = result.length - 1;

        for(int i = 0, j = r; i < nums.length && j >= 0; i++, j--) {
            int lNum = nums[i];
            int rNum = nums[j];

            if (lNum < pivot) {
                result[l++] = lNum;
            }

            if (rNum > pivot) {
                result[r--] = rNum;
            }
        }

        for (int i = l; i <= r; i++) {
            result[i] = pivot;
        }

        return result;
    }
}