// Print GFG n times
// Difficulty: EasyAccuracy: 75.76%Submissions: 95K+Points: 2
// Print GFG n times without the loop.

// Example:

// Input:
// 5
// Output:
// GFG GFG GFG GFG GFG
// Your Task:
// This is a function problem. You only need to complete the function printGfg() that takes N as parameter and prints N times GFG recursively. Don't print newline, it will be added by the driver code.


// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N) (Recursive).

// Constraint:
// 1<=N<=1000
public class printGFG {
    class Solution {

        void printGfg(int N) {
            // code here
            if(N==0){
                return;
            }
            printGfg(N-1);
            System.out.print("GFG ");
        }
    }
}
