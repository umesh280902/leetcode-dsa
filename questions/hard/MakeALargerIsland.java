// 827. Making A Large Island
// Solved
// Hard
// Topics
// Companies
// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

// Return the size of the largest island in grid after applying this operation.

// An island is a 4-directionally connected group of 1s.

 

// Example 1:

// Input: grid = [[1,0],[0,1]]
// Output: 3
// Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
// Example 2:

// Input: grid = [[1,1],[1,0]]
// Output: 4
// Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
// Example 3:

// Input: grid = [[1,1],[1,1]]
// Output: 4
// Explanation: Can't change any 0 to 1, only one island with area = 4.
 

// Constraints:

// n == grid.length
// n == grid[i].length
// 1 <= n <= 500
// grid[i][j] is either 0 or 1.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakeALargerIsland {
    
    class Solution {
    
    int [][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
    Map<Integer,Integer> component=new HashMap<>();
    
    void paint(int [][]grid,int i,int j,int color) {
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || grid[i][j]!=1) return;
        grid[i][j]=color;
        component.put(color,component.getOrDefault(color,0)+1);
        for(int []dir:dirs)
            paint(grid,i+dir[0],j+dir[1],color);
    }
    
    public int largestIsland(int [][]grid) {
        int n=grid.length,ans=0,color=2;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==0) continue;
                paint(grid,i,j,color);
                if(component.containsKey(color))
                    ans=Math.max(ans,component.get(color));
                color++;
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]!=0) continue;
                Set<Integer> neigh=new HashSet<>();
                for(int []dir:dirs) {
                    int x=i+dir[0],y=j+dir[1];
                    if(x<0 || y<0 || x>=n || y>=n || grid[x][y]==0) continue;
                    neigh.add(grid[x][y]);
                }
                
                int size=1;
                for(int s:neigh)
                    size+=component.get(s);
                
                ans=Math.max(ans,size);
            }
        }
        return ans;
    }
}
}
