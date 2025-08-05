#include <iostream>
#include <string>
#include <unordered_map>


using namespace std;

class Solution {
public:
    int computeAction(const string& word1, const string& word2, const int i, const int j) {
        std::string key = std::to_string(i) + "_" + std::to_string(j);
        
        if (i == 0) {
            return j;
        }

        if (j == 0) { 
            return i; 
        }
        
        if (computed.find(key) != computed.end()) {
            return computed[key];
        }

        if (word1[i - 1] == word2[j - 1]) {
            computed[key] = computeAction(word1, word2, i - 1, j - 1);
        } else {
            computed[key] = 1 + min({
                computeAction(word1, word2, i - 1, j),     // Delete
                computeAction(word1, word2, i, j - 1),     // Insert
                computeAction(word1, word2, i - 1, j - 1)  // Replace
            });
        }

        return computed[key];
    }

    int minDistance(string word1, string word2) {
        return computeAction(word1, word2, word1.size(), word2.size());
    }

protected:
    std::unordered_map<std::string, int> computed;
};