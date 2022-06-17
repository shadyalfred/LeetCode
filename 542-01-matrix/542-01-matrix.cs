public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        int ROWS = mat.Length;
        
        if (ROWS == 0)
            return mat;
        
        int COLS = mat[0].Length;
        
        int[][] dist = new int[ROWS][];
        for (int i = 0; i < ROWS; i++)
        {
            dist[i] = Enumerable.Repeat(int.MaxValue, COLS).ToArray();
        }
        
        Queue<(int, int)> q = new Queue<(int, int)>();
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                if (mat[i][j] == 0)
                {
                    dist[i][j] = 0;
                    q.Enqueue((i, j));
                }
            }
        }
        
        int[,] dir = new int[,]
        {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 },
        };
        
        while (q.Count > 0)
        {
            var curr = q.Dequeue();
            for (int i = 0; i < 4; i++)
            {
                var (currR, currC) = curr;
                int newR = currR + dir[i, 0];
                int newC = currC + dir[i, 1];
                
                if (newR >= 0 && newC >= 0 && newR < ROWS && newC < COLS)
                {
                    if (dist[newR][newC] > dist[currR][currC] + 1)
                    {
                        dist[newR][newC] = dist[currR][currC] + 1;
                        q.Enqueue((newR, newC));
                    }
                }
            }
        }
        return dist;
        
    }
}