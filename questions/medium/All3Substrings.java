// 1358. Number of Substrings Containing All Three Characters
// Solved
// Medium
// Topics
// Companies
// Hint
// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

// Example 1:

// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
// Example 2:

// Input: s = "aaacb"
// Output: 3
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
// Example 3:

// Input: s = "abc"
// Output: 1
 

// Constraints:

// 3 <= s.length <= 5 x 10^4
// s only consists of a, b or c characters.

public class All3Substrings {
    class Solution {
        public int numberOfSubstrings(String s) {
            int count = 0;
            int left = 0;
            int[] charCount = new int[3];
    
            for (int right = 0; right < s.length(); right++) {
                charCount[s.charAt(right) - 'a']++;
    
                while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                    count += s.length() - right;
                    charCount[s.charAt(left) - 'a']--;
                    left++;
                }
            }
    
            return count;
        }
    }
}
