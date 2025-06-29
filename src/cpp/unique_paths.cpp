#include <iostream>

class Solution {
    public:
        int uniquePaths(int m, int n) {
            if (m ==1 && n ==1) {
                return 1;
            }

            std::vector<std::vector<int>> path_matrix = std::vector<std::vector<int>>(m, std::vector<int>(n, -1));
            path_matrix[0][0] = 1;

            return computeForCell(m-1, n-1, path_matrix);

        }

        int computeForCell(int row, int col, std::vector<std::vector<int>>& path_matrix) {
            int top_neighbour;

            if (row == 0) {
                top_neighbour = 0;
            } 
            else if (row - 1 == 0) {
                top_neighbour = 1;
            }
            else if (path_matrix[row - 1][col] != -1) {
                top_neighbour = path_matrix[row - 1][col];
            }
            else {
                top_neighbour = computeForCell(row - 1, col, path_matrix);
                path_matrix[row - 1][col] = top_neighbour;
            }

            int left_neighbour;
            if (col == 0) {
                left_neighbour = 0;
            } 
            else if (col - 1 == 0) {
                left_neighbour = 1;
            }
            else if (path_matrix[row][col - 1] != -1) {
                left_neighbour = path_matrix[row][col - 1];
            }
            else {
                left_neighbour = computeForCell(row, col - 1, path_matrix);
                path_matrix[row][col - 1] = left_neighbour;
            }

            return left_neighbour + top_neighbour;
        }
};


int main() {
    auto solution = Solution();
    int result = solution.uniquePaths(51, 9);

    std::cout << result << std::endl;

    return 0;
}
