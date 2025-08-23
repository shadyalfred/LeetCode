public class Solution {
    public void Rotate(int[][] matrix) {
        int n = matrix.Length;
        int[][] m = new int[n][];

        for (int i = 0; i < n; i++) {
            m[i] = new int[n];
            for (int j = 0; j < n; j++) {
                m[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = m[n - j - 1][i];
            }
        }
    }
}