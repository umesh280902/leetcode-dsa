package questions;

// Code
// Testcase
// Testcase
// Test Result
// 34. Find First and Last Position of Element in Sorted Array
// Solved
// Medium
// Topics
// Companies
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

public class FirstAndLastOccurrence {
    class Solution {
        private int firstOccurence(int[] nums,int target){
            int start=0;
            int end=nums.length-1;
            int mid=start+(end-start)/2;
            int ans=-1;
            while(start<=end){
                if(nums[mid]==target){
                    ans=mid;
                    end=mid-1;
                }else if(nums[mid]<target){
                    start=mid+1;
                }else if(nums[mid]>target){
                    end=mid-1;
                }
                mid=start+(end-start)/2;
            }   
            return ans;
        }
        private int lastOccurence(int[] nums,int target){
            int start=0;
            int end=nums.length-1;
            int mid=start+(end-start)/2;
            int ans=-1;
            while(start<=end){
                if(nums[mid]==target){
                    ans=mid;
                    start=mid+1;
                }else if(nums[mid]<target){
                    start=mid+1;
                }else if(nums[mid]>target){
                    end=mid-1;
                }
                mid=start+(end-start)/2;
            }   
            return ans;
        }
        public int[] searchRange(int[] nums, int target) {
            int first=firstOccurence(nums,target);
            int last=lastOccurence(nums,target);
            return new int[]{first,last};
        }
    }   
}
