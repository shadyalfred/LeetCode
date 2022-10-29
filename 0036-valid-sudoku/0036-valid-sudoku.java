class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // check rows
        Set<Character> seen = null;
        
        for (int i = 0; i < rows; i++) {
            seen = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                if (seen.contains(board[i][j])) {
                    return false;
                }
                
                seen.add(board[i][j]);
            }
        }
        
        // check cols
        for (int i = 0; i < cols; i++) {
            seen = new HashSet<>();
            for (int j = 0; j < rows; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                
                if (seen.contains(board[j][i])) {
                    return false;
                }
                
                seen.add(board[j][i]);
            }
        }
        
        seen = null;
        
        // check blocks
        for (int i = 0; i < rows; i += 3) {
            for (int j = 0; j < cols; j += 3) {
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean checkBlock(int row, int col, char[][] board) {
        Set<Character> seen = new HashSet<>();
        
        int rows = row + 3;
        int cols = col + 3;
        
        for (int i = row; i < rows; i++) {
            for (int j = col; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                if (seen.contains(board[i][j])) {
                    return false;
                }
                
                seen.add(board[i][j]);
            }
        }
        
        return true;
    }
}