#include <iostream>
#include <map>

class Solution {
public:
    int deleteAndEarn(std::vector<int>& nums) {
        int n = 10001;
        std::vector<int> values(n, 0);
        for (int num : nums)
            values[num] += num;

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];
            int skipi = std::max(skip, take);
            take = takei;
            skip = skipi;
        }
        return std::max(take, skip);
    }
};

int main() {
    std::vector<int> v = {8,7,3,8,1,4,10,10,10,2};

    Solution solution;
    std::cout << solution.deleteAndEarn(v) << std::endl;

    return 0;
}