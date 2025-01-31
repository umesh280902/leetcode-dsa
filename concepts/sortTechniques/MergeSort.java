package sortTechniques;
// We will be creating 2 functions mergeSort() and merge().
// mergeSort(arr[], low, high):
// In order to implement merge sort we need to first divide the given array into two halves.
// Now, if we carefully observe, we need not divide the array and create a separate array, but we will divide the array's range into halves every time. 
// For example, the given range of the array is 0 to 4(0-based indexing). Now on the first go, we will divide the range into half like (0+4)/2 = 2.
// So, the range of the left half will be 0 to 2 and for the right half, the range will be 3 to 4.
// Similarly, if the given range is low to high, the range for the two halves will be low to mid and mid+1 to high, where mid = (low+high)/2. 
// This process will continue until the range size becomes.
// // 
// So, in mergeSort(), we will divide the array around the middle index(rather than creating a separate array) by making the recursive call:
// 1. mergeSort(arr,low,mid)   [Left half of the array]
// 2. mergeSort(arr,mid+1,high)  [Right half of the array]
// where low = leftmost index of the array, high = rightmost index of the array, and mid = middle index of the array.
// Now, in order to complete the recursive function, we need to write the base case as well.
// We know from step 2.1, that our recursion ends when the array has only 1 element left.
// So, the leftmost index, low, and the rightmost index high become the same as they are pointing to a single element.
// Base Case: if(low >= high) return;

// Time complexity: O(nlogn) 

// Reason: At each step, we divide the whole array, for that logn and we assume n steps are taken to get a sorted array, so overall time complexity will be nlogn

// Space complexity: O(n)  

// Reason: We are using a temporary array to store elements in sorted order.

// Auxiliary Space Complexity: O(n)

// Merge Sort
// Difficulty: MediumAccuracy: 54.1%Submissions: 222K+Points: 4
// Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

// Examples:

// Input: arr[] = [4, 1, 3, 9, 7]
// Output: [1, 3, 4, 7, 9]
// Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
// Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// Input: arr[] = [1, 3 , 2]
// Output: [1, 2, 3]
// Constraints:
// 1 <= arr.size() <= 105
// 1 <= arr[i] <= 105
public class MergeSort {
    class Solution {
        void merge(int arr[],int low,int mid,int high){
            int temp[]=new int[high-low+1];
            int left=low;
            int right=mid+1;
            int k=0;
            while(left<=mid&&right<=high){
                if(arr[left]<=arr[right]){
                    temp[k++]=arr[left++];
                }else{
                    temp[k++]=arr[right++];
                }
            }
            
            while(left<=mid){
                temp[k++]=arr[left++];
            }
            while(right<=high){
                temp[k++]=arr[right++];
            }
            
            for(int i=low,j=0;i<=high;i++,j++){
                arr[i]=temp[j];
            }
        }
    
        void mergeSort(int arr[], int low, int high) {
            // code here
            if(low==high){
                return;
            }
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
}
