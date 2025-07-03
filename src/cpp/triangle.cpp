#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        if (triangle.size() == 1) {
            return triangle[0][0];
        }

        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                triangle[i][j] += std::min(triangle[i + 1][j], triangle[i+1][j+1]);
            }
        }

        return triangle[0][0];
    }
};

int main() {
    Solution sol;

    vector<vector<int>> triangle_grid = {
        {-1},
        {3, 4},
        {6, 5, 7},
        {4, 1, -8, 3}
    };

    std::cout << sol.minimumTotal(triangle_grid) << std::endl;
}