#include <iostream>


class Solution {
public:
    int minPathSum(std::vector<std::vector<int>>& grid) {
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[i].size(); ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int topNeigbour = (i - 1 >= 0) ? grid[i-1][j] : INT_MAX;
                int leftNeigbour = (j - 1 >= 0) ? grid[i][j-1] : INT_MAX;

                grid[i][j] += std::min(topNeigbour, leftNeigbour);
            }
        }

        return grid[grid.size() - 1][grid[0].size() - 1];
    }
};

int main() {
    auto solution = Solution();

    std::vector<std::vector<int>> matrix = {
        {1}
    };

    std::cout << solution.minPathSum(matrix);

}