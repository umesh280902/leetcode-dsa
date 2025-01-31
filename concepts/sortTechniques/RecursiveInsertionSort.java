package sortTechniques;

// Approach: 
// In the iterative method, we did the following:

// Take an element from the unsorted array(using an outer loop).
// Place it in its corresponding position in the sorted part(using an inner loop).
// Shift the remaining elements accordingly.
// Now, in the recursive approach, we will just select the element recursively instead of using any loop. This is the only change we will do the recursive insertion sort algorithm and the rest of the part will be completely the same as it was in the case of iterative insertion sort.

// The approach will be the following:

// First, call the recursive function with the given array, the size of the array, and the index of the selected element(let's say i).
// Inside that recursive function, take the element at index i from the unsorted array.
// Then, place the element in its corresponding position in the sorted part(using swapping).
// After that, Shift the remaining elements accordingly.
// Finally, call the recursion increasing the index(i) by 1.
// The recursion will continue until the index reaches n(i.e. All the elements are covered).
// Base Case: if(i == n) return;
// The best case occurs if the given array is already sorted.
// And if the given array is already sorted, the recursion calls will only occur and inside the recursive function, the loop will run for 0 times(as each element is already present in its correct position).`
// So, our overall time complexity in the best case will boil down to O(N), where N = size of the `array.

// Insertion Sort
// Difficulty: EasyAccuracy: 66.61%Submissions: 205K+Points: 2
// The task is to complete the insertsort() function which is used to implement Insertion Sort.

// Examples:

// Input: arr[] = [4, 1, 3, 9,  7]
// Output: [1, 3, 4, 7, 9]
// Explanation: The sorted array will be [1, 3, 4, 7, 9].
// Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
// Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// Explanation: The sorted array will be [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
// Input: arr[] = [4, 1, 9]
// Output: [1, 4, 9]
// Explanation: The sorted array will be [1, 4, 9].
// Constraints:
// 1 <= arr.size() <= 1000
// 1 <= arr[i] <= 1000


public class RecursiveInsertionSort {
    class Solution {
        public void shiftRight(int[] arr,int j,int key){
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        
        
        public void recursiveInsertionSort(int arr[],int  left){
            
            if(left==arr.length){
                return;
            }
            
            int key=arr[left];
            int j=left-1;
            shiftRight(arr,j,key);
            recursiveInsertionSort(arr,left+1);
            
        }
        // Please change the array in-place
        public void insertionSort(int arr[]) {
            // code here
            // int n=arr.length;
            // int i=1;
            // int key=arr[i];
            // int j=i-1;
            // for(i=1;i<n;i++){
            //     key=arr[i];
            //     j=i-1;
            //     while(j>=0&&arr[j]>key){
            //         arr[j+1]=arr[j];
            //         j--;
            //     }
            //     arr[j+1]=key;
            // }
            recursiveInsertionSort(arr,1);
            
        }
    }
}
