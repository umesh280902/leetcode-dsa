package leetcode.Array;
// Kth Smallest
// Difficulty: MediumAccuracy: 35.17%Submissions: 662K+Points: 4
// Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array.

// Follow up: Don't solve it using the inbuilt sort function.

// Examples :

// Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
// Output:  7
// Explanation: 3rd smallest element in the given array is 7.
// Input: arr[] = [2, 3, 1, 20, 15], k = 4 
// Output: 15
// Explanation: 4th smallest element in the given array is 15.
// Expected Time Complexity: O(n+(max_element) )
// Expected Auxiliary Space: O(max_element)
// Constraints:
// 1 <= arr.size <= 106
// 1<= arr[i] <= 106
// 1 <= k <= n
import java.util.PriorityQueue;

public class KthSmallest {
    class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            minHeap.add(arr[i]);
        }
        for(int i=0;i<k-1;i++){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

}
