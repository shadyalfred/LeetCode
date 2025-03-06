class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nn = n * n;
        boolean[] doesExist = new boolean[nn];

        int[] ans = new int[2];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int num = grid[r][c] - 1;
                if (doesExist[num]) {
                    ans[0] = grid[r][c];
                } else {
                    doesExist[num] = true;
                }
            }
        }

        for (int i = 0; i < nn; i++) {
            if (!doesExist[i]) {
                ans[1] = i + 1;
                break;
            }
        }
        
        return ans;
    }
}