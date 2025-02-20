package leetcode.Array.easy;

import java.util.ArrayList;
// Union of 2 Sorted with Duplicates
// Difficulty: MediumAccuracy: 31.39%Submissions: 414K+Points: 4Average Time: 20m
// Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the elements in the union of the two arrays in sorted order.

// Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
// Examples:

// Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
// Output: 1 2 3 4 5 6 7
// Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
// Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
// Output: 1 2 3 4 5
// Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
// Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
// Output: 1 2
// Explanation: Distinct elements including both the arrays are: 1 2.
// Constraints:
// 1  <=  a.size(), b.size()  <=  105
// -109  <=  a[i] , b[i]  <=  109

public class FindUnion {
    class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> answer=new ArrayList<>();
        int x=a.length;
        int y=b.length;
        int i=0;
        int j=0;
        while(i<x&&j<y){
            while(i>0&&i<x&&a[i]==a[i-1]) i++;
            while(j>0&&j<y&&b[j]==b[j-1]) j++;
            
            if(i<x&&j<y){
                
            if(a[i]==b[j]){
                answer.add(a[i]);
                i++;
                j++;
            }else if(a[i]<b[j]){
                answer.add(a[i]);
                i++;
            }else{
                answer.add(b[j]);
                j++;
            }
            }
        }
        
        while(i<x){
            if(i==0||a[i]!=a[i-1]){
                answer.add(a[i]);
            }
            i++;
        }
        while(j<y){
            if(j==0||b[j]!=b[j-1]){
                answer.add(b[j]);
            }
            j++;
        }
        
        return answer;
    }
}
}
