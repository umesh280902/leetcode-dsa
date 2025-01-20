package medium;
// 2661. First Completely Painted Row or Column
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

// Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

// Return the smallest index i at which either a row or a column will be completely painted in mat.

 

// Example 1:

// image explanation for example 1
// Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
// Output: 2
// Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
// Example 2:

// image explanation for example 2
// Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
// Output: 3
// Explanation: The second column becomes fully painted at arr[3].
 

// Constraints:

// m == mat.length
// n = mat[i].length
// arr.length == m * n
// 1 <= m, n <= 105
// 1 <= m * n <= 105
// 1 <= arr[i], mat[r][c] <= m * n
// All the integers of arr are unique.
// All the integers of mat are unique.

// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 83K
// Submissions
// 135.5K
// Acceptance Rate
// 61.2%
// Topics
// Companies
// Hint 1
// Can we use a frequency array?
// Hint 2
// Pre-process the positions of the values in the matrix.
// Hint 3
// Traverse the array and increment the corresponding row and column frequency using the pre-processed positions.
// Hint 4
// If the row frequency becomes equal to the number of columns, or vice-versa return the current index.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintFirstCompletelyRowOrColumn {
    class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Map<Integer, int[]> positionMap = new HashMap<>();
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];
        Arrays.fill(rowCount, cols);
        Arrays.fill(colCount, rows);
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                positionMap.put(mat[r][c], new int[]{r, c});
            }
        }
        for (int idx = 0; idx < arr.length; ++idx) {
            int[] pos = positionMap.get(arr[idx]);
            if (--rowCount[pos[0]] == 0 || --colCount[pos[1]] == 0) {
                return idx;
            }
        }
        return -1;
    }
}
}
