class Solution {
    int k;

    public int findTheWinner(int n, int k) {
        this.k = k;

        return helper(n) + 1;
    }

    private int helper(int n) {
        if (n == 1) {
            return 0;
        }

        return (helper(n - 1) + k) % n;
    }
}