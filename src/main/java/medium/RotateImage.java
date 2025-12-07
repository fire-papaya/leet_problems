package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int rows = n / 2;
        int cols = n / 2;

        if (n % 2 == 0) {
            rows -= 1;
        }

        int r = matrix.length - 1;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                int buff = matrix[i][j];

                matrix[i][j] = matrix[r - j][i];
                matrix[r - j][i] = matrix[r - i][r - j];
                matrix[r - i][r - j] = matrix[j][r - i];
                matrix[j][r - i] = buff;
            }
        }
    }
}
