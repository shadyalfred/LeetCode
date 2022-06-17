public class Solution {
    public int UniquePaths(int m, int n) {
        if (n <= 0 || m <= 0)
            return 0;

        int[][] paths = new int[n][];
        for (int i = 0; i < n; i++)
        {
            paths[i] = new int[m];
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0)
                    paths[i][j] = 1;
                else
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[n - 1][m - 1];       
    }
}