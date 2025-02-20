// 1980. Find Unique Binary String
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

 

// Example 1:

// Input: nums = ["01","10"]
// Output: "11"
// Explanation: "11" does not appear in nums. "00" would also be correct.
// Example 2:

// Input: nums = ["00","01"]
// Output: "11"
// Explanation: "11" does not appear in nums. "10" would also be correct.
// Example 3:

// Input: nums = ["111","011","001"]
// Output: "101"
// Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 

// Constraints:

// n == nums.length
// 1 <= n <= 16
// nums[i].length == n
// nums[i] is either '0' or '1'.
// All the strings of nums are unique.
import java.util.HashSet;
import java.util.Set;
public class BinaryStrings {
    

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> numSet = new HashSet<>();
        for (String num : nums) {
            numSet.add(num);
        }
        return generateBinaryStrings("", numSet, n);
    }

    private String generateBinaryStrings(String current, Set<String> numSet, int n) {
        if (current.length() == n) {
            if (!numSet.contains(current)) {
                return current;
            }
            return null;
        }

        for (char c : new char[]{'0', '1'}) {
            String binaryString = generateBinaryStrings(current + c, numSet, n);
            if (binaryString != null) {
                return binaryString;
            }
        }
        return null;
    }
}
}
