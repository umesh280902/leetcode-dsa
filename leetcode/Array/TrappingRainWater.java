// 42. Trapping Rain Water
// Solved
// Hard
// Topics
// Companies
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

public class TrappingRainWater {
    class Solution {
        public int trap(int[] nums) {
            int leftHeight[]=new int[nums.length];
            int rightHeight[]=new int[nums.length];
            leftHeight[0]=0;
            rightHeight[nums.length-1]=0;
            for(int i=1;i<nums.length;i++){
                leftHeight[i]=Math.max(leftHeight[i-1],nums[i-1]);
            }
            for(int i=nums.length-2;i>=0;i--){
                rightHeight[i]=Math.max(rightHeight[i+1],nums[i+1]);
            }
            int ans=0;
            for(int i=0;i<nums.length;i++){
                int minHeight=Math.min(leftHeight[i],rightHeight[i]);
                ans+=(minHeight-nums[i])>0?minHeight-nums[i]:0;
            }
            return ans;
    
        }
    }
}
