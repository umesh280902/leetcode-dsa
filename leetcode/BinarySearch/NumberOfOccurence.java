package leetcode.BinarySearch;

// Number of occurrence
// Difficulty: EasyAccuracy: 59.34%Submissions: 313K+Points: 2Average Time: 20m
// Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

// Examples :

// Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
// Output: 4
// Explanation: target = 2 occurs 4 times in the given array so the output is 4.
// Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
// Output: 0
// Explanation: target = 4 is not present in the given array so the output is 0.
// Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
// Output: 3
// Explanation: target = 12 occurs 3 times in the given array so the output is 3.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 1 ≤ target ≤ 106

public class NumberOfOccurence {
    class Solution {
        private int firstOccurence(int[] nums, int target) {
            int start = 0, end = nums.length - 1, ans = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    end = mid - 1; // Continue searching in the left half
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return ans;
        }
    
        private int lastOccurence(int[] nums, int target) {
            int start = 0, end = nums.length - 1, ans = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    start = mid + 1; // Continue searching in the right half
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return ans;
        }
    
        int countFreq(int[] arr, int target) {
            int first = firstOccurence(arr, target);
            if (first == -1) return 0; // Target not found
    
            int last = lastOccurence(arr, target);
            return (last - first) + 1;
        }
    }
    
}
