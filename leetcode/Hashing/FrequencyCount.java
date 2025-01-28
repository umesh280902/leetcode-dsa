// Frequencies in a Limited Array
// Difficulty: EasyAccuracy: 27.64%Submissions: 338K+Points: 2
// You are given an array arr[] containing positive integers. The elements in the array arr[] range from 1 to n (where n is the size of the array), and some numbers may be repeated or absent. Your task is to count the frequency of all numbers in the range 1 to n and return an array of size n such that result[i] represents the frequency of the number i (1-based indexing).

// Examples

// Input: arr[] = [2, 3, 2, 3, 5]
// Output: [0, 2, 2, 0, 1]
// Explanation: We have: 1 occurring 0 times, 2 occurring 2 times, 3 occurring 2 times, 4 occurring 0 times, and 5 occurring 1 time.
// Input: arr[] = [3, 3, 3, 3]
// Output: [0, 0, 4, 0]
// Explanation: We have: 1 occurring 0 times, 2 occurring 0 times, 3 occurring 4 times, and 4 occurring 0 times.
// Input: arr[] = [1]
// Output: [1]
// Explanation: We have: 1 occurring 1 time, and there are no other numbers between 1 and the size of the array.
// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ arr.size()

import java.util.ArrayList;
import java.util.List;

public class FrequencyCount{
    class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        int n=arr.length;
        List<Integer> answer=new ArrayList<>();
        int[] array=new int[n+1];
        for(int i=0;i<n;i++){
            array[arr[i]]++;
        }
        
        for(int i=1;i<=n;i++){
            answer.add(array[i]);
        }
        return answer;
    }
}

}