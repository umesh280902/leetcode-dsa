package questions;

// Code
// Testcase
// Testcase
// Test Result
// 33. Search in Rotated Sorted Array
// Solved
// Medium
// Topics
// Companies
// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1
 

// Constraints:

// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -104 <= target <= 104
public class SearchInRotatedArray {
    class Solution {
        private int pivot(int nums[]){
            int start=0;
            int end=nums.length-1;
            int mid=start+(end-start)/2;
            while(start<end){
                if(nums[mid]>=nums[0]){
                    start=mid+1;
                }else{
                    end=mid;
                }
                mid=start+(end-start)/2;
            }
            return start;
        }
    
        private int BinarySearch(int nums[],int s,int e,int target){
            int start=s;
            int end=e;
            int mid=start+(end-start)/2;
            while(start<=end){
                if(nums[mid]==target){
                    return mid;
                }
                if(target>nums[mid]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
                mid=start+(end-start)/2;
            }
            return -1;
        }    
        public int search(int[] nums, int target) {
            int pivot=pivot(nums);
            int answer=0;
            if(target>=nums[pivot]&&target<=nums[nums.length-1]){
                answer=BinarySearch(nums,pivot,nums.length-1,target);
            }else{
                answer=BinarySearch(nums,0,pivot,target);
            }
            return answer;
        }
    }
}
