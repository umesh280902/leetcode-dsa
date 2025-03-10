import java.util.HashMap;
// LeetCode Logo
// Daily Question


// 5

// avatar
// Premium
// Debugging...
// Debugging...







// Run
// Description
// Editorial
// Editorial
// Solutions
// Solutions
// Accepted
// Accepted
// Submissions
// Submissions
// Code


// Testcase
// Testcase
// Test Result
// 3306. Count of Substrings Containing Every Vowel and K Consonants II
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given a string word and a non-negative integer k.

// Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.

 

// Example 1:

// Input: word = "aeioqq", k = 1

// Output: 0

// Explanation:

// There is no substring with every vowel.

// Example 2:

// Input: word = "aeiou", k = 0

// Output: 1

// Explanation:

// The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

// Example 3:

// Input: word = "ieaouqqieaouqq", k = 1

// Output: 3

// Explanation:

// The substrings with every vowel and one consonant are:

// word[0..5], which is "ieaouq".
// word[6..11], which is "qieaou".
// word[7..12], which is "ieaouq".
 

// Constraints:

// 5 <= word.length <= 2 * 105
// word consists only of lowercase English letters.
// 0 <= k <= word.length - 5
public class Vowels {
    class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private long atLeastK(String word, int k) {
        int n = word.length();
        long ans = 0;
        int consonants = 0;
        int left = 0;
        HashMap<Character, Integer> vowelMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (isVowel(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }

            while (vowelMap.size() == 5 && consonants >= k) {
                ans += n - right;
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) {
                        vowelMap.remove(leftChar);
                    }
                } else {
                    consonants--;
                }
                left++;
            }
        }
        return ans;
    }

    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }
}
}
