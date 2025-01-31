// Approach:

// Now, let’s understand how we are going to implement the logic of the above steps. 
// In the intuition, we have seen that the given array should be broken down into subarrays. 
// But while implementing, we are not going to break down and create any new arrays. 
// Instead, we will specify the range of the subarrays using two indices or pointers(i.e. low pointer and high pointer) each time while breaking down the array.
// The algorithm steps are the following for the quickSort() function:
// Initially, the low points to the first index and the high points to the last index(as the range is n i.e. the size of the array). 
// After that, we will get the index(where the pivot should be placed after sorting) while shifting the smaller elements on the left and the larger ones on the right using a partition() function discussed later.
// Now, this index can be called the partition index as it creates a partition between the left and the right unsorted subarrays.
// After placing the pivot in the partition index(within the partition() function specified), we need to call the function quickSort() for the left and the right subarray recursively. 
// So, the range of the left subarray will be [low to (partition index - 1)] and the range of the right subarray will be [(partition index + 1) to high]. 
// This is how the recursion will continue until the range becomes 1.

// Quick Sort
// Difficulty: MediumAccuracy: 55.23%Submissions: 250K+Points: 4
// Implement Quick Sort, a Divide and Conquer algorithm, to sort an array, arr[] in ascending order. 
// Given an array, arr[], with starting index low and ending index high, complete the functions partition() and quickSort(). 
// Use the last element as the pivot so that all elements less than or equal to the pivot come before it, and elements greater than the pivot follow it.

// Note: The low and high are inclusive.

// Now, let’s understand how to implement the partition() function to get the partition index.

// Inside the function, we will first select the pivot(i.e. arr[low] in our case).
// Now, we will again take two-pointers i and j. The i pointer points to low and the j points to high.
// Now, the pointer i will move forward and find the first element that is greater than the pivot. 
// Similarly, the pointer j will move backward and find the first element that is smaller than the pivot.
// Here, we need to add some checks like i <= high-1 and j >= low+1. 
// Because it might happen that i is standing at high and trying to proceed or j is standing at low and trying to exceed.
// Once we find such elements i.e. arr[i] > pivot and arr[j] < pivot, and i < j, we will swap arr[i] and arr[j].
// We will continue step 3 and step 4, until j becomes smaller than i.
// Finally, we will swap the pivot element(i.e. arr[low]) with arr[j] and will return the index j i.e. the partition index.
// Examples:
// Worst Case Time complexity: O(n2) 

// Best Case – This case occurs when the pivot is the middle element or near to middle element of the array.
// Recurrence :
// F(n) = 2F(n/2)

// Time Complexity for the best and average case: O(N*logN)

// Space Complexity: O(1) + O(N) auxiliary stack space.
// Input: arr[] = [4, 1, 3, 9, 7]
// Output: [1, 3, 4, 7, 9]
// Explanation: After sorting, all elements are arranged in ascending order.
// Input: arr[] = [2, 1, 6, 10, 4, 1, 3, 9, 7]
// Output: [1, 1, 2, 3, 4, 6, 7, 9, 10]
// Explanation: Duplicate elements (1) are retained in sorted order.
// Input: arr[] = [5, 5, 5, 5]
// Output: [5, 5, 5, 5]
// Explanation: All elements are identical, so the array remains unchanged.
// Constraints:
// 1 <= arr.size() <= 105
// 1 <= arr[i] <= 105

class Solution {
    static void swap(int arr[], int i, int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
   }

   // QuickSort function
   static void quickSort(int arr[], int low, int high) {
       if (low < high) {
           int pIndex = partition(arr, low, high);
           quickSort(arr, low, pIndex - 1);
           quickSort(arr, pIndex + 1, high);
       }
   }

   // Partition function (Lomuto Partition Scheme)
   static int partition(int arr[], int low, int high) {
       int pivot = arr[low]; // Choose pivot as the first element
       int i = low;
       int j = high;

       while (i < j) {
           while (arr[i] <= pivot && i <= high - 1) {
               i++;
           }
           while (arr[j] > pivot && j >= low + 1) { // Corrected condition
               j--;
           }
           if (i < j) {
               swap(arr, i, j);
           }
       }
       
       swap(arr, low, j); // Swap pivot with correct position
       return j; // Return correct pivot position
   }
}