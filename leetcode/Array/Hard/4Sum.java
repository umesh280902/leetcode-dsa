package leetcode.Array.Hard;


// Code


// Testcase
// Test Result
// Test Result
// 18. 4Sum
// Solved
// Medium
// Topics
// Companies
// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:

// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]
 

// Constraints:

// 1 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109

public class 4Sum {
    public class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
                for (int j = i + 1; j < n; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates
                    
                    int start = j + 1;
                    int end = n - 1;
    
                    while (start < end) {
                        long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];
    
                        if (sum == target) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                            int low = nums[start];
                            int high = nums[end];
                            start++;
                            end--;
                            while (start < end && nums[start] == low) start++; // Skip duplicates
                            while (start < end && nums[end] == high) end--;   // Skip duplicates
                        } else if (sum > target) {
                            end--;
                        } else {
                            start++;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
