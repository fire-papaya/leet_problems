#include <iostream>


class Solution {
public:
    int fib(int n) {
        if (n < 2) {
            return n;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 0;

        for (int i = 1; i < n; ++i) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
};

int main() {
    auto solution = Solution();
    int result = solution.fib(5);

    std::cout << result << std::endl;

    return 0;
}
