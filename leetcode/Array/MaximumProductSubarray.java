// 152. Maximum Product Subarray
// Solved
// Medium
// Topics
// Companies
// Given an integer array nums, find a 
// subarray
//  that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

 

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// -10 <= nums[i] <= 10
// The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
public class MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
    
            int currentMax = nums[0];
            int currentMin = nums[0];
            int maxProduct = nums[0];
    
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    // Swap currentMax and currentMin if nums[i] is negative
                    int temp = currentMax;
                    currentMax = currentMin;
                    currentMin = temp;
                }
    
                // Update currentMax and currentMin
                currentMax = Math.max(nums[i], currentMax * nums[i]);
                currentMin = Math.min(nums[i], currentMin * nums[i]);
    
                // Update the global maxProduct
                maxProduct = Math.max(maxProduct, currentMax);
            }
    
            return maxProduct;
        }
    }
    
}
