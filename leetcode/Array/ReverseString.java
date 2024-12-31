package leetcode.Array;

// Code
// Code Sample
// Code Sample
// Testcase
// Testcase
// Test Result
// 344. Reverse String
// Solved
// Easy
// Topics
// Companies
// Hint
// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

 

// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
 

// Constraints:

// 1 <= s.length <= 105
// s[i] is a printable ascii character.
public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            int start=0;
            int end=s.length-1;
            while(start<end){
                swap(s,start,end);
                start++;
                end--;
            }
        }
    
        private void swap(char[] s,int i,int j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }
    }
}
