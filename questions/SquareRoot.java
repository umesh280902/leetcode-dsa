package questions;
// 69. Sqrt(x)
// Solved
// Easy
// Topics
// Companies
// Hint
// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

// You must not use any built-in exponent function or operator.

// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

// Example 1:

// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.
// Example 2:

// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

// Constraints:

// 0 <= x <= 231 - 1

public class SquareRoot {
    class Solution {
        private int BinarySearch(int x) {
            int start = 0;
            int end = x;
            int mid;
            int answer = -1;
    
            while (start <= end) {
                mid = start + (end - start) / 2;
    
                // Use long to prevent overflow when computing square
                long square = (long) mid * mid;
    
                if (square == x) {
                    return mid; // Exact square root found
                }
                if (square < x) {
                    answer = mid; // Update answer to the current mid
                    start = mid + 1; // Move to the right half
                } else {
                    end = mid - 1; // Move to the left half
                }
            }
            return answer; // Return the largest integer whose square is ≤ x
        }
        
        private double precision(int x,int precision,int sol){
            double factor=1;
            double answer=sol;
            for(int i=0;i<precision;i++){
                factor/=10;
                for(double j=0;j*j<x;j=j+factor){
                     answer=j;
                }
            }
            return answer;
        }
    
        public int mySqrt(int x) {
            double answer=precision(x, 3, BinarySearch(x));
            System.out.print(answer);
            return BinarySearch(x);

        }
    }
    
}
