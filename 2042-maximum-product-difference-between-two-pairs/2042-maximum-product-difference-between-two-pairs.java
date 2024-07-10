class Solution {
    public int maxProductDifference(int[] nums) {
        int num1 = Integer.MIN_VALUE, // biggest number
        num2 = Integer.MIN_VALUE;     // second biggest number

        int num3 = Integer.MAX_VALUE, // smallest number
        num4 = Integer.MAX_VALUE;     // second smallest number

        for (int num : nums) {
            if (num > num1) {
                num2 = num1;
                num1 = num;
            } else if (num > num2) {
                num2 = num;
            }

            if (num < num4) {
                num3 = num4;
                num4 = num;
            } else if (num < num3) {
                num3 = num;
            }
        }

        return num1 * num2 - num3 * num4;
    }
}