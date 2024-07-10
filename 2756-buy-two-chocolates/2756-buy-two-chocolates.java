class Solution {
    public int buyChoco(int[] prices, int money) {
        // Keep track of the two minimums of prices
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (var price : prices) {
            if (price < min1) {
                min2 = min1;
                min1 = price;
            } else if (price < min2) {
                min2 = price;
            }
        }

        int sum = min1 + min2;

        if (sum <= money) {
            return money - sum;
        }

        return money;
    }
}