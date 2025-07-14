#include <vector>
#include <iostream>

using namespace std;


class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int max_side = 0;

        int m = matrix.size();
        int n = matrix[0].size();

        std::vector<std::vector<int>> solution_matrix(m, std::vector<int>(n, 0));

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                 // in the first col and row max size can only be 1, so no computation needed
                if (matrix[i][j] == '1' && (i == 0 || j == 0)) {
                    max_side = std::max(max_side, 1);
                    solution_matrix[i][j] = 1;
                    continue;
                }

                if (matrix[i][j] == '1') {
                    solution_matrix[i][j] = std::min(std::min(solution_matrix[i-1][j], solution_matrix[i][j - 1]), solution_matrix[i-1][j-1]) + 1;
                    max_side = std::max(max_side, solution_matrix[i][j]);
                }
                
            }
        }
        return max_side * max_side;
    }
};

int main() {
    Solution sol;

    std::vector<std::vector<char>> matrix = {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}
    };


    int result = sol.maximalSquare(matrix);

    std::cout << result;

    return 0;
}