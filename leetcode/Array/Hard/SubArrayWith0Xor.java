package Hard;

// Subarray with given XOR
// Programming
// Hashing
// medium
// 52.2% Success

// 985

// 20

// Bookmark
// Asked In:
// Problem Description
 
 

// Given an array of integers A and an integer B.

// Find the total number of subarrays having bitwise XOR of all elements equals to B.



// Problem Constraints
// 1 <= length of the array <= 105

// 1 <= A[i], B <= 109
import java.util.HashMap;

public class SubArrayWith0Xor {
    public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,1);
        int count=0;
        int n=A.length;
        int xr=0;
        for(int i=0;i<n;i++){
            xr=xr^A[i];
            int x=xr^B;
            if(hashMap.containsKey(x)){
                count+=hashMap.get(x);
            }
            
            if(hashMap.containsKey(xr)){
                hashMap.put(xr,hashMap.get(xr)+1);
            }else{
                hashMap.put(xr,1);
            }
        }
        return count;
    }
}
   
}
