class Solution {
    public int findTheWinner(int n, int k) {
        // See https://www.youtube.com/watch?v=PBBQgW_75e0 for
        // explanation.
        int result = 0;

        for (int players = 1; players <= n; players++) {
            result = (result + k) % players;
        }

        return result + 1;
    }
}