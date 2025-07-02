# include <iostream>

using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int obstacle = -1;
        int m = obstacleGrid.size();
        int n = obstacleGrid[m - 1].size();

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j< n; ++j) {
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                    continue;
                } else if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = obstacle;
                    continue;
                } else {

                    int topNeighbour = (i > 0 && obstacleGrid[i-1][j] != obstacle) ? obstacleGrid[i-1][j] : 0;
                    int leftNeighbour = (j > 0 && obstacleGrid[i][j-1] != obstacle) ? obstacleGrid[i][j-1] : 0;
                
                    obstacleGrid[i][j] = topNeighbour + leftNeighbour;
                }
            }
        }



        return obstacleGrid[m - 1][n - 1];
    }
};

int main() {
    Solution solution;

    std::vector<std::vector<int>> matrix = {
        {0, 1, 0}
    };

    std::cout << solution.uniquePathsWithObstacles(matrix) << std::endl;
}