class Solution {
    private int n;
    
    private boolean dfs(int acc, int e) {
        if (acc == n) {
            return true;
        }

        if (e > n) {
            return false;
        }

        if (acc > n) {
            return false;
        }

        int newE = e * 3;

        return dfs(acc + e, newE) || dfs(acc, newE);
    }

    public boolean checkPowersOfThree(int n) {
        this.n = n;
        return dfs(0, 1);
    }
}