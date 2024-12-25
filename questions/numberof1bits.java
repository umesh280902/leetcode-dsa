// 191. Number of 1 Bits
// Solved
// Easy
// Topics
// Companies
// Given a positive integer n, write a function that returns the number of 
// set bits
//  in its binary representation (also known as the Hamming weight).

 

// Example 1:

// Input: n = 11

// Output: 3

// Explanation:

// The input binary string 1011 has a total of three set bits.

// Example 2:

// Input: n = 128

// Output: 1

// Explanation:

// The input binary string 10000000 has a total of one set bit.
package questions;

public class numberof1bits {
    class Solution {
        public int hammingWeight(int n) {
            int count=0;
            while(n!=0){
                if((n&1)==1){
                    count++;
                }
                
                n=n>>1;
            }
            return count;
        }
    }    
}