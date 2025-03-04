class Solution {
    private int n;
    private int[] pwrs;

    private boolean dfs(int acc, int i) {
        if (i >= pwrs.length) {
            return false;
        }

        if (acc > n) {
            return false;
        }

        if (acc == n) {
            return true;
        }

        return dfs(acc + pwrs[i], i + 1) || dfs(acc, i + 1);
    }

    public boolean checkPowersOfThree(int n) {
        this.n = n;
        this.pwrs = new int[17];
        pwrs[0] = 1;
        for (int i = 1; i < pwrs.length; i++) {
            pwrs[i] = pwrs[i - 1] * 3;
        }
        return dfs(0, 0);
    }
}