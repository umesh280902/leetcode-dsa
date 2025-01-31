package sortTechniques;
// Bubble Sort
// Difficulty: EasyAccuracy: 59.33%Submissions: 261K+Points: 2
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
public class RecursiveBubbleSort {
    class Solution {
        public static void swap(int arr[],int i,int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        public static void  recursiveBubbleSort(int arr[],int n){
            if(n==1){
                return;
            }
            
            boolean swapped=false;
            for(int i=0;i<=n-2;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    swapped=true;
                }
            }
            
            if(swapped==false){
                return;
            }
            
            recursiveBubbleSort(arr,n-1);
            
            
        }
        
        // Function to sort the array using bubble sort algorithm.
        public static void bubbleSort(int arr[]) {
            // code here
            int n=arr.length;
            recursiveBubbleSort(arr,n);
        }
    }
}
