import java.util.HashMap;
// 1079. Letter Tile Possibilities
// Solved
// Medium
// Topics
// Companies
// Hint
// You have n  tiles, where each tile has one letter tiles[i] printed on it.

// Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

// Example 1:

// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
// Example 2:

// Input: tiles = "AAABBC"
// Output: 188
// Example 3:

// Input: tiles = "V"
// Output: 1
 

// Constraints:

// 1 <= tiles.length <= 7
// tiles consists of uppercase English letters.
public class LetterTilesPossibilites {
    class Solution {
    public int backtrack(HashMap<Character,Integer> hashmap){
        int count=0;
        for(char ch:hashmap.keySet()){
            if(hashmap.get(ch)>0){
                hashmap.put(ch,hashmap.get(ch)-1);
                count+=1+backtrack(hashmap);
                hashmap.put(ch,hashmap.get(ch)+1);
            }
        }
        return count;
    }


    public int numTilePossibilities(String tiles) {
        HashMap<Character,Integer> hashmap=new HashMap<>();
        for(char ch:tiles.toCharArray()){
            hashmap.put(ch,hashmap.getOrDefault(ch,0)+1);
        }
        return backtrack(hashmap);
    }
}
}
