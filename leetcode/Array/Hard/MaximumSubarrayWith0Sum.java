// Largest subarray with 0 sum
// Difficulty: MediumAccuracy: 41.84%Submissions: 393K+Points: 4Average Time: 20m
// Given an array arr containing both positive and negative integers, the task is to compute the length of the largest subarray that has a sum of 0.

// Examples:

// Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
// Output: 5
// Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
// Input: arr[] = [2, 10, 4]
// Output: 0
// Explanation: There is no subarray with a sum of 0.
// Input: arr[] = [1, 0, -4, 3, 1, 0]
// Output: 5
// Explanation: The subarray is [0, -4, 3, 1, 0].
// Constraints:
// 1 ≤ arr.size() ≤ 106
// −103 ≤ arr[i] ≤ 103, for each valid i
public class MaximumSubarrayWith0Sum{
    class Solution {
        int maxLen(int arr[]) {
            // code here
            HashMap<Integer,Integer> hashmap=new HashMap<>();
            int n=arr.length;
            int maximum=0;
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i];
                if(sum==0){
                    maximum=i+1;
                }else{
                    if(hashmap.get(sum)!=null){
                        maximum=Math.max(maximum,i-hashmap.get(sum));
                    }else{
                        hashmap.put(sum,i);
                    }
                }
            }
            return maximum;
        }
    }
}