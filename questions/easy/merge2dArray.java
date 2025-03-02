package questions.easy;
// Code
// Code Sample
// Code Sample
// Testcase
// Testcase
// Test Result
// 2570. Merge Two 2D Arrays by Summing Values
// Solved
// Easy
// Topics
// Companies
// Hint
// You are given two 2D integer arrays nums1 and nums2.

import java.util.ArrayList;

// nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
// Each array contains unique ids and is sorted in ascending order by id.

// Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

// Only ids that appear in at least one of the two arrays should be included in the resulting array.
// Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
// Return the resulting array. The returned array must be sorted in ascending order by id.

 

// Example 1:

// Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
// Output: [[1,6],[2,3],[3,2],[4,6]]
// Explanation: The resulting array contains the following:
// - id = 1, the value of this id is 2 + 4 = 6.
// - id = 2, the value of this id is 3.
// - id = 3, the value of this id is 2.
// - id = 4, the value of this id is 5 + 1 = 6.
// Example 2:

// Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
// Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
// Explanation: There are no common ids, so we just include each id with its value in the resulting list.
 

// Constraints:

// 1 <= nums1.length, nums2.length <= 200
// nums1[i].length == nums2[j].length == 2
// 1 <= idi, vali <= 1000
// Both arrays contain unique ids.
// Both arrays are in strictly ascending order by id.
class merge2dArray {

    class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            ArrayList<int[]> answer=new ArrayList<>();

            int n=nums1.length;
            int m=nums2.length;
            int i=0;
            int j=0;
            while(i<n&&j<m){
                //fetch the details of the id and all;
                int id1=nums1[i][0];
                int value1=nums1[i][1];
                int id2=nums2[j][0];
                int value2=nums2[j][1];
                if(id1==id2){
                    int value=value1+value2;
                    answer.add(new int[]{id1,value});
                    i++;
                    j++;
                }else if(id1<id2){
                    answer.add(new int[]{id1,value1});
                    i++;
                }else{
                    answer.add(new int[]{id2,value2});
                    j++;
                }
    
            }
                if(i<n){
                    while(i<n){
                       answer.add(new int[]{nums1[i][0],nums1[i][1]});
                       i++; 
                    }
                }
    
                if(j<m){
                    while(j<m){
                        answer.add(new int[]{nums2[j][0],nums2[j][1]});
                        j++;
                    }
                }
                return answer.toArray(new int[answer.size()][]);
    
        }
    }
}