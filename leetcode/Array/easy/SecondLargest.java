package leetcode.Array.easy;
// Second Largest
// Difficulty: EasyAccuracy: 26.72%Submissions: 981K+Points: 2
// Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

// Note: The second largest element should not be equal to the largest element.

// Examples:

// Input: arr[] = [12, 35, 1, 10, 34, 1]
// Output: 34
// Explanation: The largest element of the array is 35 and the second largest element is 34.
// Input: arr[] = [10, 5, 10]
// Output: 5
// Explanation: The largest element of the array is 10 and the second largest element is 5.
// Input: arr[] = [10, 10, 10]
// Output: -1
// Explanation: The largest element of the array is 10 and the second largest element does not exist.
// Constraints:
// 2 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 105
public class SecondLargest {
    class Solution {
        public int getSecondLargest(int[] arr) {
            int n = arr.length;
            if (n < 2) { // Check if the array has at least 2 elements
                return -1;
            }
            
            int large = Integer.MIN_VALUE;
            int secondLarge = Integer.MIN_VALUE;
            
            for (int i = 0; i < n; i++) {
                if (arr[i] > large) {
                    secondLarge = large;
                    large = arr[i];
                } else if (arr[i] > secondLarge && arr[i] != large) {
                    secondLarge = arr[i];
                }
            }
            
            return (secondLarge == Integer.MIN_VALUE) ? -1 : secondLarge; // Handle case where all elements are the same
        }
    }
    
}
