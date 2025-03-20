package Hard;
// 56. Merge Intervals
// Solved
// Medium
// Topics
// Companies
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

import java.util.*;
public class MergeIntervals {
    
    
    class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> merged=new ArrayList<>();
        int[] currentInterval=intervals[0];
        merged.add(currentInterval);
        for(int[] interval:intervals){
            int currentEnd=currentInterval[1];
            int nextStart=interval[0];
            int nextEnd=interval[1];
            if(currentEnd>=nextStart){
                currentInterval[1]=Math.max(currentEnd,nextEnd);
            }else{
                currentInterval=interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}

}