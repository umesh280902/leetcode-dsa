package leetcode.Array;


// Code
// Code Sample
// Code Sample
// Testcase
// Testcase
// Test Result
// 905. Sort Array By Parity
// Solved
// Easy
// Topics
// Companies
// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

// Return any array that satisfies this condition.

 

// Example 1:

// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 5000
// 0 <= nums[i] <= 5000

public class EvenOddByParity {
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int left=0;
            int right=0;
            int length=nums.length;
    
            while(right<length){
                if(nums[right]%2==0){
                    swap(nums,left,right);
                    left++;
                }
                right++;
            }
            return nums;
        }
    
        private void swap(int arr[],int i,int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
}   