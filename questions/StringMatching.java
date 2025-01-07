package questions;

// 1408. String Matching in an Array
// Solved
// Easy
// Topics
// Companies
// Hint
// Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

// A substring is a contiguous sequence of characters within a string

 

// Example 1:

// Input: words = ["mass","as","hero","superhero"]
// Output: ["as","hero"]
// Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
// ["hero","as"] is also a valid answer.
// Example 2:

// Input: words = ["leetcode","et","code"]
// Output: ["et","code"]
// Explanation: "et", "code" are substring of "leetcode".
// Example 3:

// Input: words = ["blue","green","bu"]
// Output: []
// Explanation: No string of words is substring of another string.
 

// Constraints:

// 1 <= words.length <= 100
// 1 <= words[i].length <= 30
// words[i] contains only lowercase English letters.
// All the strings of words are unique.

import java.util.ArrayList;
import java.util.List;

public class StringMatching {
    class Solution {
    public List<String> stringMatching(String[] words) {
        int n=words.length;
        List<String> answer=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&words[j].contains(words[i])){
                    answer.add(words[i]);
                    break;
                }
            }
        }
        return answer;
    }
}
}
