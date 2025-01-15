package leetcode.basics;
// Sum 1 to n Divisors
// Difficulty: EasyAccuracy: 43.37%Submissions: 192K+Points: 2
// Given a positive integer n, The task is to find the value of Σi F(i) where i is from 1 to n and function F(i) is defined as the sum of all divisors of i.

// Examples:

// Input: n = 4
// Output: 15
// Explanation:
// F(1) = 1
// F(2) = 1 + 2 = 3
// F(3) = 1 + 3 = 4
// F(4) = 1 + 2 + 4 = 7
// So, F(1) + F(2) + F(3) + F(4)
//     = 1 + 3 + 4 + 7 = 15
// Input: n = 5
// Output: 21
// Explanation:
// F(1) = 1
// F(2) = 1 + 2 = 3
// F(3) = 1 + 3 = 4
// F(4) = 1 + 2 + 4 = 7
// F(5) = 1 + 5 = 6
// So,  F(1) + F(2) + F(3) + F(4) + F(5)
//     = 1 + 3 + 4 + 7 + 6 = 21
// Input: n = 1
// Output: 1
// Explanation:
// F(1) = 1
// So,  F(1) = 1 
// Constraints:
// 1 <= n <= 105
public class SumOfNDivisors {
    class Solution {
        public static int sumOfDivisors(int n) {
            // code here
            long[] sum=new long[n+1];
            for(int i=1;i<=n;i++){
                for(int j=i;j<=n;j+=i){
                    sum[j]+=i;
                }
            }
            int sumTotal=0;;
            for(int i=1;i<=n;i++){
                sumTotal+=sum[i];
            }
            return sumTotal;
        }
    }
}
