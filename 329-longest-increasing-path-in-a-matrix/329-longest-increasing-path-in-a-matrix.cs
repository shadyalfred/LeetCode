public class Solution
{
  public int LongestIncreasingPath(int[][] matrix)
  {
    if (matrix.Length == 0 || matrix[0].Length == 0)
      return 0;

    int N = matrix.Length, M = matrix[0].Length;
    int?[,] pathFrom = new int?[N, M];

    int answer = 0;
    
    for (int i = 0; i < N; i++)
    {
      for (int j = 0; j < M; j++)
      {
        answer = Math.Max(answer, CalculatePathFrom(i, j, matrix, pathFrom));
      }
    }

    return answer;
  }

  private int CalculatePathFrom(int i, int j, int[][] matrix, int?[,] pathFrom) {
    if (pathFrom[i, j].HasValue)
    {
      return pathFrom[i, j].Value;
    }

    pathFrom[i, j] = 1;

    int[] di = { -1, 1, 0, 0 };
    int[] dj = { 0, 0, -1, 1 };

    for (int k = 0; k < 4; k++)
    {
      int newI = i + di[k], newJ = j + dj[k];

      if (
        newI < 0 ||
        newI >= matrix.Length ||
        newJ < 0 ||
        newJ >= matrix[newI].Length
      )
      {
        continue;
      }
      
      if (matrix[i][j] >= matrix[newI][newJ])
      {
        continue;
      }

      pathFrom[i, j] = Math.Max(pathFrom[i, j].Value,
                                1 + CalculatePathFrom(newI, newJ, matrix, pathFrom));
    }

    return pathFrom[i, j].Value;
  } 
}