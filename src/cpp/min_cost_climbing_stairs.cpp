# include <iostream>

namespace std {

class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        if (cost.size() == 2) {
            return min(cost[0], cost[1]);
        }

        for (int i = 2; i < cost.size(); ++i) {
            cost[i] += min(cost[i - 1], cost[i - 2]);
        }

        return min(cost[cost.size() - 1], cost[cost.size() - 2]);
    }
};


}

int main() {
    std::Solution solution = std::Solution();
    std::vector<int> v = {1,100,1,1,1,100,1,1,100,1};

    int result = solution.minCostClimbingStairs(v);

    std::cout << result << std::endl;

    return 0;
}