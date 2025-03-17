package Hard;

// Code
// Testcase
// Testcase
// Test Result
// 229. Majority Element II
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
 

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1=Integer.MIN_VALUE;
        int element2=Integer.MIN_VALUE;
        int count1=0;
        int count2=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(count1==0&&element2!=nums[i]){
                count1++;
                element1=nums[i];
            }else if(count2==0&&element1!=nums[i]){
                count2++;
                element2=nums[i];
            }else if(nums[i]==element1) count1++;
            else if(nums[i]==element2) count2++;
            else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(element1==nums[i]) count1++;
            if(element2==nums[i]) count2++;
        }
        List<Integer> answer=new ArrayList<>();
        if(count1>n/3) answer.add(element1);
        if(count2>n/3) answer.add(element2);
        return answer;
    }
}
}
