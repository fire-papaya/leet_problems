#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int longest_palyndrome_length = 1;
        int longest_palyndrom_start = 0;

        for (int i = 0; i < s.length(); ++i) {
            // Even case
            int k = i;
            int j = i + 1;

            int palyndrome_length = 0;
            while (s[k] == s[j] && k >= 0 && j < s.length()) {
                palyndrome_length += 2;
                k--;
                j++;
            }

            if (palyndrome_length > longest_palyndrome_length) {
                longest_palyndrome_length = palyndrome_length;
                longest_palyndrom_start = k + 1;
            }

            // Odd case
            if (i > 0) {
                k = i-1;
                j = i+1;
                palyndrome_length = 1;
                while (s[k] == s[j] && k >= 0 && j < s.length()) {
                    palyndrome_length += 2;
                    k--;
                    j++;
                }
            }

            if (palyndrome_length > longest_palyndrome_length) {
                longest_palyndrome_length = palyndrome_length;
                longest_palyndrom_start = k + 1;
            }

        }

        return s.substr(longest_palyndrom_start, longest_palyndrome_length);
    }
};

int main () {
    auto sol = Solution();
    
    std::cout << sol.longestPalindrome("babad") << std::endl;

    return 0;
}