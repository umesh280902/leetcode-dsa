package leetcode.Array;
// 45. Jump Game II
// Solved
// Medium
// Topics
// Companies
// You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

// 0 <= j <= nums[i] and
// i + j < n
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [2,3,0,1,4]
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000
// It's guaranteed that you can reach nums[n - 1].
public class MinimumJumpsToReachEnd {
    class Solution {
        public int jump(int[] arr) {
            if (arr.length == 1) {
                return 0; // No jump needed for a single element
            }
    
            int current = 0; // Farthest reachable with current jumps
            int far = 0;     // Farthest reachable so far
            int jumps = 0;   // Number of jumps made
            int n = arr.length;
    
            for (int i = 0; i < n; i++) {
                far = Math.max(far, i + arr[i]); // Update farthest reachable
    
                // If the current range ends
                if (i == current) {
                    jumps++;          // Increment jump count
                    current = far;    // Update current range
    
                    // Check if the last index is reachable
                    if (current >= n - 1) {
                        return jumps;
                    }
                }
            }
    
            return -1; // If the last index is not reachable
        }
    }
    
}
