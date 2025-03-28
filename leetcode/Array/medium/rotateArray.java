package leetcode.Array.medium;

// 189. Rotate Array
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
 

// Constraints:

// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105
 
public class rotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n=nums.length;
            k=k%n;
            swap(nums,0,n-1);
            swap(nums,0,k-1);
            swap(nums,k,n-1);
        }
    
        public void swap(int[] nums,int start,int end){
            while(start<end){
                nums[start]=nums[start]^nums[end];
                nums[end]=nums[start]^nums[end];
                nums[start]=nums[start]^nums[end];
                start++;
                end--;
            }
        }
    }
}


//for rotating to left 
class Solution {
    public void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Ensure k is within bounds
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[i] = nums[(i + k) % n]; // Shift elements to the left
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i]; // Copy back to the original array
        }
    }
}
