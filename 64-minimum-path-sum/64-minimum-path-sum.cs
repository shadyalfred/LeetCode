public class Solution {
    public int MinPathSum(int[][] grid) {
        int m = grid.Length;
        int n = grid[0].Length;
        
        int[,] minimumSums = new int[m, n];
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                minimumSums[i, j] = grid[i][j];
                if (i == 0 && j == 0)
                {
                    continue;
                }
                else if (i == 0)
                {
                    minimumSums[i, j] += minimumSums[i, j - 1];
                }
                else if (j == 0)
                {
                    minimumSums[i, j] += minimumSums[i - 1, j];
                }
                else
                {
                    minimumSums[i, j] += Math.Min(minimumSums[i - 1, j], minimumSums[i, j - 1]);
                }
            }
        }
        return minimumSums[m - 1, n - 1];
    }
}