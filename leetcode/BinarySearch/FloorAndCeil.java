package leetcode.BinarySearch;

// Ceil The Floor
// Difficulty: EasyAccuracy: 43.76%Submissions: 172K+Points: 2
// Given an unsorted array arr[] of integers and an integer x, find the floor and ceiling of x in arr[].

// Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is smaller than smallest element of arr[].
// Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greatest element of arr[].

// Return an array of integers denoting the [floor, ceil]. Return -1 for floor or ceiling if the floor or ceiling is not present.

// Examples:

// Input: x = 7 , arr[] = [5, 6, 8, 9, 6, 5, 5, 6]
// Output: 6, 8
// Explanation: Floor of 7 is 6 and ceil of 7 is 8.
// Input: x = 10 , arr[] = [5, 6, 8, 8, 6, 5, 5, 6]
// Output: 8, -1
// Explanation: Floor of 10 is 8 but ceil of 10 is not possible.
// Expected Time Complexity: O(n)
// Expected Auxiliary Space: O(1)

// Constraints :
// 1 ≤ arr.size ≤ 105
// 1 ≤ arr[i], x ≤ 106

import java.util.Arrays;

public class FloorAndCeil {
    class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr); // Ensure the array is sorted
        int left = 0, right = arr.length - 1;
        int floor = -1, ceil = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                return new int[]{x, x}; // Exact match
            } else if (arr[mid] < x) {
                floor = arr[mid]; // Store floor
                left = mid + 1;   // Move right
            } else {
                ceil = arr[mid];  // Store ceil
                right = mid - 1;  // Move left
            }
        }

        return new int[]{floor, ceil};
    }
}
}
