#include <string>

namespace std {
    class Solution {
    public:
        int strStr(string haystack, string needle) {
            int i, j, counter;
            if (haystack.length() < needle.length())
                return -1;

            for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
                counter = 0;
                for (j = 0; j < needle.length(); j++) {
                    if (haystack[i + j] == needle[j]) {
                        counter++;
                    } else {
                        counter = 0;
                        break;
                    }
                }

                if (counter == needle.length())
                    return i;
            }

            return -1;
        }
    };

}

