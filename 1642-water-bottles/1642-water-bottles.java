class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            int rest = numBottles % numExchange;

            result += newBottles;

            numBottles = newBottles + rest;
        }

        return result;
    }
}