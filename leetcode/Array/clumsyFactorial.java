
// Code


// Testcase
// Test Result
// Test Result
// 1006. Clumsy Factorial
// Solved
// Medium
// Topics
// Companies
// The factorial of a positive integer n is the product of all positive integers less than or equal to n.

// For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.
// We make a clumsy factorial using the integers in decreasing order by swapping out the multiply operations for a fixed rotation of operations with multiply '*', divide '/', add '+', and subtract '-' in this order.

// For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.
// However, these operations are still applied using the usual order of operations of arithmetic. We do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.

// Additionally, the division that we use is floor division such that 10 * 9 / 8 = 90 / 8 = 11.

// Given an integer n, return the clumsy factorial of n.

 

// Example 1:

// Input: n = 4
// Output: 7
// Explanation: 7 = 4 * 3 / 2 + 1
// Example 2:

// Input: n = 10
// Output: 12
// Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 

// Constraints:

// 1 <= n <= 10


public class clumsyFactorial {
    class Solution {
        public int clumsy(int n) {
            int ans = 1;
            if(n <= 4){
                if(n <= 2) return n;
                else if(n == 3) return 6;
                else if(n == 4) return 7;
            } else {
                if(n%4 == 1 || n%4 == 2) ans = n+2;
                else if(n%4 == 3) ans = n-1;
                else ans = n+1;
            }
            return ans;
        }
    }
}
