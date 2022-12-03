class Solution {

    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        // 1a) Capture unsurrounded regions - top and bottom row (O -> T)
        for (int i = 0; i < COLS; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[ROWS - 1][i] == 'O') dfs(board, ROWS - 1, i);
        }

        // 1b) Capture unsurrounded regions - Left and right columns (O -> T)
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][COLS - 1] == 'O') dfs(board, i, COLS - 1);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X'; // 2) Capture surrounded regions (O -> X)
                if (board[r][c] == 'T') board[r][c] = 'O'; // 3) Uncapture unsurrounded regions (T- O)
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if (
            r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != 'O'
        ) return;

        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
