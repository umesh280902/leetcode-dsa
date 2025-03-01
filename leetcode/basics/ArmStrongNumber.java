package leetcode.basics;
// Armstrong Numbers
// Difficulty: EasyAccuracy: 49.88%Submissions: 166K+Points: 2
// You are given a 3-digit number n, Find whether it is an Armstrong number or not.

// An Armstrong number of three digits is a number such that the sum of the cubes of its digits is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371. 

// Note: Return true if it is an Armstrong number else return false.

// Examples

// Input: n = 153
// Output: true
// Explanation: 153 is an Armstrong number since 13 + 53 + 33 = 153. 
// Input: n = 372
// Output: false
// Explanation: 372 is not an Armstrong number since 33 + 73 + 23 = 378. 
// Input: n = 100
// Output: false
// Explanation: 100 is not an Armstrong number since 13 + 03 + 03 = 1. 
// Constraints:
// 100 ≤ n <1000 


public class ArmStrongNumber {
    // User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int original=n;
        int sum=0;
        while(n!=0){
            int lastDigit=n%10;
            sum+=(int)Math.pow(lastDigit,3);
            n=n/10;
        }
        return original==sum;
    }
}
}
