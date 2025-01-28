// 2658. Maximum Number of Fish in a Grid
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

// A land cell if grid[r][c] = 0, or
// A water cell containing grid[r][c] fish, if grid[r][c] > 0.
// A fisher can start at any water cell (r, c) and can do the following operations any number of times:

// Catch all the fish at cell (r, c), or
// Move to any adjacent water cell.
// Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

 

// Example 1:


// Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
// Output: 7
// Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.
// Example 2:


// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
// Output: 1
// Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish. 
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// 0 <= grid[i][j] <= 10

import java.util.LinkedList;
import java.util.Queue;

public class MaximumFish {
    class Solution {
        private int bfs(int i,int j,int[][] grid){
            int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
            int n=grid.length;
            int m=grid[0].length;
            Queue<int[]> queue=new LinkedList<>();
            queue.add(new int[]{i,j});
            int fish=grid[i][j];
            grid[i][j]=0;
            while(!queue.isEmpty()){
                int[] cell=queue.poll();
                int x=cell[0];
                int y=cell[1];
                for(int[] direct:directions){
                    int a=x+direct[0];
                    int b=y+direct[1];
                    if(a>=0&&a<n&&b>=0&&b<m&&0<grid[a][b]){
                        queue.add(new int[]{a,b});
                        fish+=grid[a][b];
                        grid[a][b]=0;
                    }
                }    
            }
            return fish;
        }
    
        public int findMaxFish(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            Queue<Integer> queue=new LinkedList<>();
            int answer=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]>0){
                        answer=Math.max(answer,bfs(i,j,grid));
                    }
                }
            }
            return answer;
        }
    }
}
