class Solution {
    private int maxArea;
    boolean[][] visited;
    int ROWS;
    int COLS;
    int[][] grid;
    int area = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.ROWS = grid.length;
        this.COLS = grid[0].length;
        
        this.visited = new boolean[ROWS][COLS];
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (visited[i][j] || grid[i][j] == 0) continue;
                
                area = 0;
                maxArea = Math.max(dfs(i, j), maxArea);
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int i, int j) {
        if (i < 0 || i == ROWS ||
            j < 0 || j == COLS ||
            visited[i][j] ||
            grid[i][j] == 0
        ) {
            return area;
        }
        
        area++;
        
        visited[i][j] = true;
        
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
        
        return area;
    }
}