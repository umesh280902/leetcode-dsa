package leetcode.Array;


// Code
// Accepted
// Accepted
// Code Sample
// Code Sample
// Testcase
// Testcase
// Test Result
// 349. Intersection of Two Arrays
// Solved
// Easy
// Topics
// Companies
// Given two integer arrays nums1 and nums2, return an array of their 
// intersection
// . Each element in the result must be unique and you may return the result in any order.

 

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.
 

// Constraints:

// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000

public class IntersectionOfTwoArrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int[] temp=new int[1001];
            for(int num:nums1){
                temp[num]=1;
            }
            int count=0;
            for(int num:nums2){
                if(temp[num]==1){
                    count++;
                    temp[num]=2;
                }
            }
            int[] answer=new int[count];
            int j=0;
            for(int num:nums2){
                if(temp[num]==2){
                    temp[num]=1;
                    answer[j]=num;
                    j++;
                }
            }
            return answer;
    
    
    
        }
    }
}
