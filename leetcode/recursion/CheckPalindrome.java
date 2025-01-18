package leetcode.recursion;
// 125. Valid Palindrome
// Solved
// Easy
// Topics
// Companies
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

// Given a string s, return true if it is a palindrome, or false otherwise.

 

// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
// Example 3:

// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.
 

// Constraints:

// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.
public class CheckPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            String str=cleanedString(s);
            return checkPalindrome(str,0,str.length()-1);
        }
    
        private String cleanedString(String s){
            StringBuilder str=new StringBuilder();
            for(char c:s.toCharArray()){
                if(Character.isLetterOrDigit(c)){
                    str.append(Character.toLowerCase(c));
                }
            }
            return str.toString();
        }
    
        private boolean checkPalindrome(String str,int start,int end){
            if(start>=end){
                return true;
            }
    
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
    
            return checkPalindrome(str,start+1,end-1);
        }
    }
}
