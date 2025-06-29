#include <iostream>

class Solution {
public:
    int climbStairs(int n) {
        if (n < 4) return n;

        int prev1 = 3;
        int prev2 = 2;

        int current = 0;

        for (int i = 3; i < n; ++i) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

};

int main() {
    auto solution = Solution();
    int result = solution.climbStairs(5);

    std::cout << result << std::endl;

    return 0;
}
