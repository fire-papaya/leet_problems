package medium;

public class CheckSudokuBoard {
    public boolean isValidSudoku(char[][] board) {
        int[][][] counts = new int[3][9][9]; // 0 - indexed

        int rowsIndex = 0;
        int colsIndex = 0;
        int squareIndex = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int digit = board[i][j] - '1'; // to get 0 - indexed

                if (counts[rowsIndex][i][digit] == 0) {
                    counts[rowsIndex][i][digit] += 1;
                } else {
                    return false;
                }

                if (counts[colsIndex][j][digit] == 0) {
                    counts[colsIndex][j][digit] += 1;
                } else {
                    return false;
                }

                int sq =  ((i / 3) * 3) + j / 3;

                if (counts[squareIndex][sq][digit] == 0) {
                    counts[squareIndex][sq][digit] += 1;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
