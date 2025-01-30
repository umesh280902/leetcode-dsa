package sortTechniques;

// Selection Sort
// Difficulty: EasyAccuracy: 64.33%Submissions: 174K+Points: 2
// Given an array arr, use selection sort to sort arr[] in increasing order.

// Examples :

// Input: arr[] = [4, 1, 3, 9, 7]
// Output: [1, 3, 4, 7, 9]
// Explanation: Maintain sorted (in bold) and unsorted subarrays. Select 1. Array becomes 1 4 3 9 7. Select 3. Array becomes 1 3 4 9 7. Select 4. Array becomes 1 3 4 9 7. Select 7. Array becomes 1 3 4 7 9. Select 9. Array becomes 1 3 4 7 9.
// Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
// Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// Input: arr[] = [38, 31, 20, 14, 30]
// Output: [14, 20, 30, 31, 38]
// Constraints:
// 1 ≤ arr.size() ≤ 103
// 1 ≤ arr[i] ≤ 106

// Corrected Explanation of Selection Sort:
//  1. Selection Sort is a sorting algorithm used for arrays.  
//  2. In Selection Sort, we divide the array into two segments:  
//  - A sorted segment (initially empty).  
//  - An unsorted segment (initially the entire array).  
//  3. We repeatedly find the smallest (or largest) element from the unsorted segment and swap it with the first element of the unsorted segment.  
//  4. This process continues, expanding the sorted segment one element at a time until the entire array is sorted.  
//  5.Time complexity: O(N ^2), (where N = size of the array), for the best, worst, and average cases.
// Reason: If we carefully observe, we can notice that the outer loop, say i, is running from 0 to n-2 i.e. n-1 times, and for each i, the inner loop j runs from i to n-1. For, i = 0, the inner loop runs n-1 times, for i = 1, the inner loop runs n-2 times, and so on. So, the total steps will be approximately the following: (n-1) + (n-2) + (n-3) + ……..+ 3 + 2 + 1. The summation is approximately the sum of the first n natural numbers i.e. (n*(n+1))/2. The precise time complexity will be O(n2/2 + n/2). Previously, we have learned that we can ignore the lower values as well as the constant coefficients. So, the time complexity is O(n2). Here the value of n is N i.e. the size of the array.
// Space Complexity: O(1) 

public class SelectionSort {
    class Solution {
        void selectionSort(int[] arr) {
            // code here
            int n=arr.length;
            int temp=0;
            for(int i=0;i<n-1;i++){
                int index=i;
                for(int j=i+1;j<n;j++){
                    if(arr[index]>arr[j]){
                        index=j;
                    }
                }
                temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
            }   
        }
    }
}
