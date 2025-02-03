package leetcode.Array.easy;
// 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
// Solved
// Easy
// Topics
// Companies
// You are given an array of integers nums. Return the length of the longest 
// subarray
//  of nums which is either 
// strictly increasing
//  or 
// strictly decreasing
// .

 

// Example 1:

// Input: nums = [1,4,3,3,2]

// Output: 2

// Explanation:

// The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

// The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

// Hence, we return 2.

// Example 2:

// Input: nums = [3,3,3,3]

// Output: 1

// Explanation:

// The strictly increasing subarrays of nums are [3], [3], [3], and [3].

// The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

// Hence, we return 1.

// Example 3:

// Input: nums = [3,2,1]

// Output: 3

// Explanation:

// The strictly increasing subarrays of nums are [3], [2], and [1].

// The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

// Hence, we return 3.

 

// Constraints:

// 1 <= nums.length <= 50
// 1 <= nums[i] <= 50
public class StrictlyIncreasingOrDecreasing {
    class Solution {
        public int longestMonotonicSubarray(int[] arr) {
            int inc=1;
            int incMax=1;
            int dec=1;
            int decMax=1;
            int n=arr.length;
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    dec++;
                }else{
                    decMax=Math.max(dec,decMax);
                    dec=1;
                }
                if(arr[i]<arr[i+1]){
                    inc++;
                }else{
                    incMax=Math.max(inc,incMax);
                    inc=1;
                }
            }
            incMax=Math.max(inc,incMax);
            decMax=Math.max(dec,decMax);
            return Math.max(incMax,decMax);
        }
    }
}
