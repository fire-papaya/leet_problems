#include <iostream>

class Solution {
public:
    int rob(std::vector<int>& nums) {
        if (nums.size() == 1)
            return nums[0];
        else if (nums.size() == 2)
            return std::max(nums[0], nums[1]);
        else if (nums.size() == 3)
            return std::max(nums[0] + nums[2], nums[1]);

        int total_robbed = 0;
        
        for(int i = 2; i < nums.size(); ++i) {
            int house_p1 = nums[i - 2];
            int house_p2 = i > 2 ? nums[i - 3] : 0;

            nums[i] += std::max(house_p1, house_p2);

            if (nums[i] > total_robbed)
                total_robbed = nums[i];
        }

        return total_robbed;
    }
};

int main() {
    std::vector<int> v = {1,2,3,1,1,1,7,9,0,8};

    Solution solution;
    std::cout << solution.rob(v) << std::endl;

}