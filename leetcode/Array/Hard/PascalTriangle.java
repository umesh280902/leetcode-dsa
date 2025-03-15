package Hard;

// 118. Pascal's Triangle
// Solved
// Easy
// Topics
// Companies
// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]
 

// Constraints:

// 1 <= numRows <= 30

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    class Solution {
    public List<Integer> generateRow(int row){
        List<Integer> list=new ArrayList<>();
        int answer=1;
        list.add(answer);
        for(int column=1;column<row;column++){
            answer=answer*(row-column);
            answer=answer/(column);
            list.add(answer);
        }
        return list;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int iterator=1;iterator<=numRows;iterator++){
            List<Integer> resultRow=generateRow(iterator);
            result.add(resultRow);
        }
        return result;
    }
}
}
