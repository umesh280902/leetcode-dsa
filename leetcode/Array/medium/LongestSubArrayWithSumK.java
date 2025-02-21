package leetcode.Array.medium;
import java.util.HashMap;

// Longest Subarray with Sum K
// Difficulty: MediumAccuracy: 24.64%Submissions: 596K+Points: 4
// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

// Examples:

// Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
// Output: 6
// Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
// Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
// Output: 5
// Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
// Input: arr[] = [10, -10, 20, 30], k = 5
// Output: 0
// Explanation: No subarray with sum = 5 is present in arr[].
// Constraints:
// 1 ≤ arr.size() ≤ 105
// -104 ≤ arr[i] ≤ 104
// -109 ≤ k ≤ 109



public class LongestSubArrayWithSumK {

    class Solution {
        public int longestSubarray(int[] arr, int k) {
            int n = arr.length;
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            int sum = 0;
            int maxLen = 0;
            
            for (int i = 0; i < n; i++) {
                sum += arr[i];
    
                // If the sum itself equals k, update maxLen
                if (sum == k) {
                    maxLen = i + 1;
                }
    
                // Check if (sum - k) exists in the map
                int remaining = sum - k;
                if (hashmap.containsKey(remaining)) {
                    int len = i - hashmap.get(remaining);
                    maxLen = Math.max(maxLen, len);
                }
    
                // Store the first occurrence of sum in the map
                if (!hashmap.containsKey(sum)) {
                    hashmap.put(sum, i);
                }
            }
            return maxLen;
        }
    }
    
}
