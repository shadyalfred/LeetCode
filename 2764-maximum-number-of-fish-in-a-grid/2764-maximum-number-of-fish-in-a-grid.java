class Solution {
  private int[][] grid;

  private int dfs(int r, int c, boolean[][] beenVisited) {
    if (r == grid.length || c == grid[0].length) {
      return 0;
    }

    if (r < 0 || c < 0) {
      return 0;
    }

    if (beenVisited[r][c]) {
      return 0;
    }

    if (grid[r][c] == 0) {
      return 0;
    }

    beenVisited[r][c] = true;
    return grid[r][c]
      + dfs(r + 1, c, beenVisited)
      + dfs(r, c + 1, beenVisited)
      + dfs(r - 1, c, beenVisited)
      + dfs(r, c - 1, beenVisited);
  }

  public int findMaxFish(int[][] grid) {
    this.grid = grid;
    int max = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] != 0) {
          max = Math.max(max, dfs(r, c, new boolean[grid.length][grid[0].length]));
        }
      }
    }
    return max;
  }
}
