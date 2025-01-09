// 78. Subsets
// Solved
// Medium
// Topics
// Companies
// Given an integer array nums of unique elements, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        createSubset(nums,0,result,subset);
        return result;
    }

    private void createSubset(int nums[],int index,List<List<Integer>> result,List<Integer> subset){
        if(index==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        createSubset(nums,index+1,result,subset);

        subset.remove(subset.size()-1);
        createSubset(nums,index+1,result,subset);
    }
}
}
