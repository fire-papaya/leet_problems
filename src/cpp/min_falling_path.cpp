#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        if (matrix.size() == 1) {
            return matrix[0][0];
        }

        int sz = matrix.size();

        int currMin = INT_MAX;

        for (int i = 1; i < sz; ++i) {
            for (int j = 0; j < sz; ++j) {
                int leftParentCol = std::max(j - 1, 0);
                int rightParentCol = std::min(j + 1, sz - 1);
                int topParentCol = j;

                matrix[i][j] += std::min(matrix[i - 1][leftParentCol], std::min(matrix[i - 1][topParentCol], matrix[i - 1][rightParentCol]));

                if ((i == sz - 1) && currMin > matrix[i][j]) {
                    currMin = matrix[i][j];
                }
            }
        }

        return currMin;
    }
};

int main() {
    auto solution = Solution();

    std::vector<std::vector<int>> matrix = {
        {2, 1, 3},
        {6, 5, 4},
        {7, 8, 9}
    };

    std::cout << solution.minFallingPathSum(matrix) << std::endl;
    char a = '0';
    std::cout << int(a == '1');

}
