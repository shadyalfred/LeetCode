class Solution {
    int ROWS;
    int COLS;
    char[][] board;

    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;

        ROWS = board.length;
        COLS = board[0].length;

        this.word = word;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (check(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(
        int i,
        int j,
        int cur
    ) {
        if (cur == word.length()) return true;
        
        if (
            i < 0 ||
            j < 0 ||
            i == ROWS ||
            j == COLS ||
            board[i][j] != word.charAt(cur)
        ) return false;


        board[i][j] += 100;

        if (check(i + 1, j, cur + 1) ||
            check(i, j + 1, cur + 1) ||
            check(i - 1, j, cur + 1) ||
            check(i, j - 1, cur + 1)) {
            return true;
        }

        board[i][j] -= 100;

        return false;
    }
}