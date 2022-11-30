class Solution {
    char[][] board;
    int ROWS;
    int COLS;
    
    String targetWord;
    
    Set<String> visited = new HashSet();
    
    StringBuilder currentWord = new StringBuilder();
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        
        this.ROWS = board.length;
        this.COLS = board[0].length;
        
        this.targetWord = word;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (visited.contains(i + "-" + j)) continue;
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(int row, int col, int i) {
        if (i == targetWord.length()) {
            return true;
        }
        
        
        String coor = row + "-" + col;
        
        if (row == ROWS ||
            row < 0 ||
            col == COLS ||
            col < 0 ||
            targetWord.charAt(i) != board[row][col] ||
            visited.contains(coor)) {
            return false;
        }
        
        currentWord.append(board[row][col]);
        visited.add(coor);
        if (dfs(row + 1, col, i + 1) ||
            dfs(row - 1, col, i + 1) ||
            dfs(row, col + 1, i + 1) ||
            dfs(row, col - 1, i + 1)) {
            return true;
        }
        
        currentWord.deleteCharAt(currentWord.length() - 1);
        visited.remove(coor);
        
        return false;
    }
}