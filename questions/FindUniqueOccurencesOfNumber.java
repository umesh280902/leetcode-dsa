package questions;
// 1207. Unique Number of Occurrences
// Solved
// Easy
// Topics
// Companies
// Hint
// Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

// Example 1:

// Input: arr = [1,2,2,1,1,3]
// Output: true
// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
// Example 2:

// Input: arr = [1,2]
// Output: false
// Example 3:

// Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
// Output: true
 
import java.util.HashMap;
import java.util.HashSet;


public class FindUniqueOccurencesOfNumber{
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            // Map to store frequencies of elements
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();
            
            for (int num : arr) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
    
            // Set to check uniqueness of frequencies
            HashSet<Integer> frequencySet = new HashSet<>(frequencyMap.values());
            
            // If the size of the set is equal to the size of the map, all frequencies are unique
            return frequencyMap.size() == frequencySet.size();
        }
    }
    
}