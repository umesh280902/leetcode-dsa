public package questions.medium;
// 1415. The k-th Lexicographical String of All Happy Strings of Length n
// Solved
// Medium
// Topics
// Companies
// Hint
// A happy string is a string that:

// consists only of letters of the set ['a', 'b', 'c'].
// s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
// For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

// Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

// Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

 

// Example 1:

// Input: n = 1, k = 3
// Output: "c"
// Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
// Example 2:

// Input: n = 1, k = 4
// Output: ""
// Explanation: There are only 3 happy strings of length 1.
// Example 3:

// Input: n = 3, k = 9
// Output: "cab"
// Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
 

// Constraints:

// 1 <= n <= 10
// 1 <= k <= 100
import java.util.ArrayList;

class GenerateAHappyString {

    class Solution {
    public void generateHappy(int n,StringBuilder str,ArrayList<String> answer){
        if(str.length()==n){
            //appending the string to answer when the string of length n has generated
            answer.add(str.toString());
            return;
        }
        //for the characters from a to c 
        for(char ch='a';ch<='c';ch++){
            //checking if the string has length 0 or the string's last character is not equal to ch 
            if(str.length()==0||str.charAt(str.length()-1)!=ch){
                //append the charactter ch
                str.append(ch);
                //recursively calling the function
                generateHappy(n,str,answer);
                //backtracking 
                str.deleteCharAt(str.length()-1);
            }
        }
    }


    public String getHappyString(int n, int k) {
        ArrayList<String> answer=new ArrayList<>();
        generateHappy(n,new StringBuilder(),answer);

        if(answer.size()<k){
            return "";
        }

        return answer.get(k-1);
    }
}
}