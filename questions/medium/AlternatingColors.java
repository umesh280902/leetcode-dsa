// 3208. Alternating Groups II
// Medium
// Topics
// Companies
// Hint
// There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:

// colors[i] == 0 means that tile i is red.
// colors[i] == 1 means that tile i is blue.
// An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).

// Return the number of alternating groups.

// Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.

 

// Example 1:

// Input: colors = [0,1,0,1,0], k = 3

// Output: 3

// Explanation:



// Alternating groups:



// Example 2:

// Input: colors = [0,1,0,0,1,0,1], k = 6

// Output: 2

// Explanation:



// Alternating groups:



// Example 3:

// Input: colors = [1,1,0,1], k = 4

// Output: 0

// Explanation:



 

// Constraints:

// 3 <= colors.length <= 105
// 0 <= colors[i] <= 1
// 3 <= k <= colors.length

// Seen this question in a real interview before?
// 1/5
// Yes
// No
public class AlternatingColors {
    class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int n = colors.length;
            int count = 0;
            int validCount = 1;  
            for (int i = 1; i < k; i++) {
                if (colors[i] != colors[i - 1]) {
                    validCount++;
                }
            }
            if (validCount == k) count++;
    
            // Sliding window
            for (int i = 1; i < n; i++) {
                int removeIndex = i - 1;
                int addIndex = (i + k - 1) % n;
                if (colors[removeIndex] != colors[(removeIndex + 1) % n]) {
                    validCount--;
                }
    
                if (colors[addIndex] != colors[(addIndex - 1 + n) % n]) {
                    validCount++;
                }
                if (validCount == k) {
                    count++;
                }
            }
    
            return count;
        }
    }
    
}
