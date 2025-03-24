// 3169. Count Days Without Meetings
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

// Return the count of days when the employee is available for work but no meetings are scheduled.

// Note: The meetings may overlap.

 

// Example 1:

// Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

// Output: 2

// Explanation:

// There is no meeting scheduled on the 4th and 8th days.

// Example 2:

// Input: days = 5, meetings = [[2,4],[1,3]]

// Output: 1

// Explanation:

// There is no meeting scheduled on the 5th day.

// Example 3:

// Input: days = 6, meetings = [[1,6]]

// Output: 0

// Explanation:

// Meetings are scheduled for all working days.

 

// Constraints:

// 1 <= days <= 109
// 1 <= meetings.length <= 105
// meetings[i].length == 2
// 1 <= meetings[i][0] <= meetings[i][1] <= days

import java.util.Arrays;
import java.util.Comparator;
public class CountDaysWithoutMeetings {

class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days; // If no meetings, all days are free.

        // Sort meetings by starting time
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]); // Sorting by start time
            }
        });

        int skip = 0;
        int lastEnd = 0; // Tracks the last occupied day

        for (int[] meeting : meetings) {
            int currentStart = meeting[0];
            int currentEnd = meeting[1];

            // Count free days between the last meeting and the current one
            if (lastEnd < currentStart - 1) {
                skip += (currentStart - lastEnd - 1);
            }

            // Extend the last occupied day
            lastEnd = Math.max(lastEnd, currentEnd);
        }

        // Count free days after the last meeting
        if (lastEnd < days) {
            skip += (days - lastEnd);
        }

        return skip;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] meetings = {{2, 4}, {6, 8}, {1, 3}};
        int days = 10;
        System.out.println(sol.countDays(days, meetings)); // Expected output: 5 (Days 5, 7, 9, 10 are free)
    }
}

}
