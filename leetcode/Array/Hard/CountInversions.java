package leetcode.Array.Hard;

// Count Inversions
// Difficulty: MediumAccuracy: 16.93%Submissions: 640K+Points: 4
// Given an array of integers arr[]. Find the Inversion Count in the array.
// Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
// If an array is sorted in the reverse order then the inversion count is the maximum. 

// Examples:

// Input: arr[] = [2, 4, 1, 3, 5]
// Output: 3
// Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
// Input: arr[] = [2, 3, 4, 5, 6]
// Output: 0
// Explanation: As the sequence is already sorted so there is no inversion count.
// Input: arr[] = [10, 10, 10]
// Output: 0
// Explanation: As all the elements of array are same, so there is no inversion count.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 104

public class CountInversions {
    

// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[]) {
        // Your Code Here
        long ans = mergeSort(arr, 0, arr.length - 1);
        return ans;
    }

    static long mergeSort(long arr[], int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += mergeSortCount(arr, left, mid, right);
        }
        return count;
    }

    static long mergeSortCount(long arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        long l[] = new long[n1];
        long r[] = new long[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            r[i] = arr[mid + 1 + i]; // Fix: Copying from mid+1
        }

        int i = 0, j = 0, k = left;
        long count = 0;

        // Merge the two subarrays and count inversions
        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
                count += (n1 - i); // Count inversions
            }
        }

        // Copy remaining elements of l[] if any
        while (i < n1) {
            arr[k++] = l[i++];
        }

        // Copy remaining elements of r[] if any
        while (j < n2) {
            arr[k++] = r[j++];
        }
        return count;
    }
}
}
