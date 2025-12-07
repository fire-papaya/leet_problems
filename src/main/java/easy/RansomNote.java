package easy;

import java.util.Arrays;
import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        var letterMap = new char[26];

        magazine.chars().forEach(c -> {
            letterMap[c - 'a'] += 1;
        });

        for (char c : ransomNote.toCharArray()) {
            if (letterMap[c - 'a'] <= 0) {
                return false;
            }
            letterMap[c - 'a'] -= 1;
        }

        return true;
    }
}
