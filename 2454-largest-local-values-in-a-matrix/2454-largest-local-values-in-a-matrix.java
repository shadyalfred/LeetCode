class Solution {
    public int[][] largestLocal(int[][] grid) {
        int N = grid.length;
        int M = N - 2;

        int[][] locals = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int max = 0;

                for (int row = i; row <= i + 2; row++) {
                    for (int col = j; col <= j + 2; col++) {
                        max = Math.max(max, grid[row][col]);
                    }
                }
                
                locals[i][j] = max;
            }
        }

        return locals;
    }
}