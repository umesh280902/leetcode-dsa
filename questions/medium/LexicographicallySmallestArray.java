// 2948. Make Lexicographically Smallest Array by Swapping Elements
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given a 0-indexed array of positive integers nums and a positive integer limit.

// In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.

// Return the lexicographically smallest array that can be obtained by performing the operation any number of times.

// An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.

 

// Example 1:

// Input: nums = [1,5,3,9,8], limit = 2
// Output: [1,3,5,8,9]
// Explanation: Apply the operation 2 times:
// - Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
// - Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
// We cannot obtain a lexicographically smaller array by applying any more operations.
// Note that it may be possible to get the same result by doing different operations.
// Example 2:

// Input: nums = [1,7,6,18,2,1], limit = 3
// Output: [1,6,7,18,1,2]
// Explanation: Apply the operation 3 times:
// - Swap nums[1] with nums[2]. The array becomes [1,6,7,18,2,1]
// - Swap nums[0] with nums[4]. The array becomes [2,6,7,18,1,1]
// - Swap nums[0] with nums[5]. The array becomes [1,6,7,18,1,2]
// We cannot obtain a lexicographically smaller array by applying any more operations.
// Example 3:

// Input: nums = [1,7,28,19,10], limit = 3
// Output: [1,7,28,19,10]
// Explanation: [1,7,28,19,10] is the lexicographically smallest array we can obtain because we cannot apply the operation on any two indices.
 

// Constraints:

// 1 <= nums.length <= 105
// 1 <= nums[i] <= 109
// 1 <= limit <= 109

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LexicographicallySmallestArray{
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[] res=new int[n];

        // Create a 2D array to store each number with its original index
        int[][] numsSort= new int[n][];
        for(int i=0; i<n; i++){
            numsSort[i]=new int[]{nums[i], i};
        }
        
        // Sort the array based on the numbers
        Arrays.sort(numsSort, (a,b)->a[0]-b[0]);

        // Map to store groups of numbers within the limit
        Map<Integer, Deque<Integer>> map=new HashMap<>();

        // Array to store group number for each original index
        int[] grpArr=new int[n];
        int grpNo=0;

        // Initialize the first group with the first element
        grpArr[numsSort[0][1]]=grpNo;
        map.put(grpNo, new ArrayDeque<>());
        map.get(grpNo).addLast(numsSort[0][0]);


        // Group numbers that are within the limit of each other
        for(int i=1; i<n; i++){
            if(numsSort[i][0]-map.get(grpNo).getLast()<=limit){
                // Add to current group if within limit
                map.get(grpNo).addLast(numsSort[i][0]);
                grpArr[numsSort[i][1]]=grpNo;
            }
            else{
                // Start a new group if beyond limit
                grpNo++;
                map.put(grpNo, new ArrayDeque<>());
                map.get(grpNo).addLast(numsSort[i][0]);
                grpArr[numsSort[i][1]]=grpNo;
            }
        }


        // Construct the result array
        for(int i=0; i<n; i++){
            // Assign the smallest available number from each group
            res[i]=map.get(grpArr[i]).pollFirst();
        }

        return res;
    }
}
}