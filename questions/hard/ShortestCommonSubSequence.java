// 1092. Shortest Common Supersequence 
// Solved
// Hard
// Topics
// Companies
// Hint
// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

// A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

// Example 1:

// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
// Explanation: 
// str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
// str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
// The answer provided is the shortest such string that satisfies these properties.
// Example 2:

// Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
// Output: "aaaaaaaa"
 

// Constraints:

// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of lowercase English letters.

public class ShortestCommonSubSequence {
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int n=str1.length();
            int m=str2.length();
            int[][] dp=new int[n+1][m+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
    
                }
            }
            int row=n;
            int col=m;
            StringBuilder str=new StringBuilder();
            while(col>0&&row>0){
                if(str1.charAt(row-1)==str2.charAt(col-1)){
                    str.append(str1.charAt(row-1));
                    row--;
                    col--;
                }else{
                    if(dp[row-1][col]>dp[row][col-1]){
                        str.append(str1.charAt(row-1));
                        row--;
                    }else{
                        str.append(str2.charAt(col-1));
                        col--;
                    }
                }
            }
    
            while(row>0){
                str.append(str1.charAt(row-1));
                row--;
            }
            while(col>0){
                str.append(str2.charAt(col-1));
                col--;
            }
            return str.reverse().toString();
        }
    }
}
