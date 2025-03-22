package Hard;

// Missing And Repeating
// Difficulty: EasyAccuracy: 24.83%Submissions: 576K+Points: 2Average Time: 30m
// Given an unsorted array arr of positive integers. One number a from the set [1, 2,....,n] is missing and one number b occurs twice in the array. Find numbers a and b.

// Note: The test cases are generated such that there always exists one missing and one repeating number within the range [1,n].

// Examples:

// Input: arr[] = [2, 2]
// Output: [2, 1]
// Explanation: Repeating number is 2 and smallest positive missing number is 1.
// Input: arr[] = [1, 3, 3] 
// Output: [3, 2]
// Explanation: Repeating number is 3 and smallest positive missing number is 2.
// Input: arr[] = [4, 3, 6, 2, 1, 1]
// Output: [1, 5]
// Explanation: Repeating number is 1 and the missing number is 5.
// Constraints:
// 2 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ arr.size()

import java.util.ArrayList;

public class MissingAndRepating {
    class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
       int n=arr.length;
       int repeating =-1;
       int missing=-1;
       for(int i=0; i<n; i++){
           int current = Math.abs(arr[i]);
           if(arr[current -1]<0){
           repeating = current;
           }
           else{
               arr[current-1]=-arr[current-1];
           }
       }
       for(int i=0; i<n; i++){
           if(arr[i]>0){
               missing =i+1;
           }
       }
       ArrayList<Integer> result= new ArrayList<>();
       result.add(repeating);
       result.add(missing);
       return result;
    }
    
}
}
