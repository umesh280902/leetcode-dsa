package leetcode.Array.Hard;

// 493. Reverse Pairs
// Solved
// Hard
// Topics
// Companies
// Hint
// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
 

// Example 1:

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
// Example 2:

// Input: nums = [2,4,3,5,1]
// Output: 3
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
// (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -231 <= nums[i] <= 231 - 1

public class ReversePairs {
    class Solution {
        void merge(int arr[], int low, int mid, int high) {
            int temp[] = new int[high - low + 1];
            int left = low;
            int right = mid + 1;
            int k = 0;
    
            while (left <= mid && right <= high) {
                if (arr[left] <= arr[right]) {
                    temp[k++] = arr[left++];
                } else {
                    temp[k++] = arr[right++];
                }
            }
    
            while (left <= mid) {
                temp[k++] = arr[left++];
            }
            while (right <= high) {
                temp[k++] = arr[right++];
            }
    
            for (int i = low, j = 0; i <= high; i++, j++) {
                arr[i] = temp[j];
            }
        }
    
        public int countPairs(int[] arr, int low, int mid, int high) {
            int count = 0;
            int right = mid + 1;
    
            for (int i = low; i <= mid; i++) {  // Fix loop start index
                while (right <= high && arr[i] > 2L * arr[right]) { 
                    right++;
                }
                count += (right - (mid + 1));  // Add valid pairs count
            }
            return count;
        }
    
        int mergeSort(int arr[], int low, int high) {
            int count = 0;
            if (low >= high) return 0;  // Correct base case
    
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += countPairs(arr, low, mid, high);
            merge(arr, low, mid, high);
            
            return count;
        }
    
        public int reversePairs(int[] nums) {
            return mergeSort(nums, 0, nums.length - 1);
        }
    }
    
}
