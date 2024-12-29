package questions;
// 410. Split Array Largest Sum
// Solved
// Hard
// Topics
// Companies
// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

// Return the minimized largest sum of the split.

// A subarray is a contiguous part of the array.

 

// Example 1:

// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
// Example 2:

// Input: nums = [1,2,3,4,5], k = 2
// Output: 9
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

// Constraints:

// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 106
// 1 <= k <= min(50, nums.length)
public class LargestSplitArraySum {
    class Solution {
        private boolean isPossible(int[] nums,int k,int mid){
            int kCount=1;
            int pageSum=0;
            for(int i=0;i<nums.length;i++){
                if(pageSum+nums[i]<=mid){
                    pageSum+=nums[i];
                }else{
                    kCount++;
                    if(kCount>k||nums[i]>mid){
                        return false;
                    }
                    pageSum=nums[i];
                }
            }
            return true;
        }
        private int BinarySearch(int[] nums,int k){
            int start=0;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
            }
            int end=sum;
            int ans=-1;
            int mid=start+(end-start)/2;
            while(start<=end){
            if(isPossible(nums,k,mid)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
                mid=start+(end-start)/2;
            }
            return ans;
    
        }
    
        public int splitArray(int[] nums, int k) {
          return BinarySearch(nums,k);
        }
    }    
}
