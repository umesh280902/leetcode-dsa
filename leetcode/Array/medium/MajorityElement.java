package leetcode.Array.medium;

// Code
// Testcase
// Testcase
// Test Result
// 169. Majority Element
// Solved
// Easy
// Topics
// Companies
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
 

// Constraints:

// n == nums.length
// 1 <= n <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow-up: Could you solve the problem in linear time and in O(1) space?


public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int count=1;
            int element=nums[0];
            for(int i=1;i<nums.length;i++){
                if(count==0){
                    element=nums[i];
                    count=1;
                }else if(element==nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
            return element;
        }
    }
}
