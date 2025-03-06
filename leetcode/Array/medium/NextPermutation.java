package leetcode.Array.medium;


// Code


// Testcase
// Testcase
// Test Result
// 31. Next Permutation
// Solved
// Medium
// Topics
// Companies
// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:

// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:

// Input: nums = [1,1,5]
// Output: [1,5,1]
public class NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            if(nums.length<=1){
                return;
            }
    
            int i=nums.length-2;
            //from the second last element find a number till 0 which is just greater than previous element 
            while(i>=0&&nums[i+1]<=nums[i]) i--;
    
            if(i>=0){
                int j=nums.length-1;
                //from last element till i find a number which is smaller that ith element
                while(i<j&&nums[i]>=nums[j]) j--;
                //swap them
                swap(nums,i,j);
            }
            //reverse the element from the next ith element to last element
            reverse(nums,i+1,nums.length-1);
    
        }   
        public void swap(int[] arr,int i,int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    
        public void reverse(int[] arr,int i ,int j){
            while(i<j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
    
    }   
}
