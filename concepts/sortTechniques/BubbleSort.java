package sortTechniques;

// //Approach:

// The algorithm steps are as follows:

// First, we will select the range of the unsorted array. For that, we will run a loop(say i) that will signify the last index of the selected range. The loop will run backward from index n-1 to 0(where n = size of the array). The value i = n-1 means the range is from 0 to n-1, and similarly, i = n-2 means the range is from 0 to n-2, and so on.
// Within the loop, we will run another loop(say j, runs from 0 to i-1 though the range is from 0 to i) to push the maximum element to the last index of the selected range, by repeatedly swapping adjacent elements.
// Basically, we will swap adjacent elements(if arr[j] > arr[j+1]) until the maximum element of the range reaches the end.
// Thus, after each iteration, the last part of the array will become sorted. Like: after the first iteration, the array up to the last index will be sorted, and after the second iteration, the array up to the second last index will be sorted, and so on.
// After (n-1) iteration, the whole array will be sorted.
// Note: Here, after each iteration, the array becomes sorted up to the last index of the range. That is why the last index of the range decreases by 1 after each iteration. This decrement is achieved by the outer loop and the last index is represented by variable i in the following code. And the inner loop(i.e. j) helps to push the maximum element of range [0….i] to the last index(i.e. index i).
// Time Complexity: O(N^2) for the worst and average cases and O(N) for the best case. Here, N = size of the array.
// Space Complexity: O(1)
// Bubble Sort
// Difficulty: EasyAccuracy: 59.33%Submissions: 260K+Points: 2
// Given an array, arr[]. Sort the array using bubble sort algorithm.

// Examples :

// Input: arr[] = [4, 1, 3, 9, 7]
// Output: [1, 3, 4, 7, 9]
// Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
// Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// Input: arr[] = [1, 2, 3, 4, 5]
// Output: [1, 2, 3, 4, 5]
// Explanation: An array that is already sorted should remain unchanged after applying bubble sort.
// Constraints:
// 1 <= arr.size() <= 103
// 1 <= arr[i] <= 103
public class BubbleSort {
    class Solution {
        // Function to sort the array using bubble sort algorithm.
        public static void bubbleSort(int arr[]) {
            // code here
            int n=arr.length;
            int temp=0;
            boolean swap=false;
            for(int i=n-1;i>=0;i--){
                swap=false;
                for(int j=0;j<i;j++){
                    if(arr[j]>arr[j+1]){
                        temp=arr[j+1];
                        arr[j+1]=arr[j];
                        arr[j]=temp;
                        swap=true;
                    }
                }
                if(swap==false){
                    break;
                }
            }
        }
    }
}
