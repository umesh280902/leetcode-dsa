

// A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

// Example 1:

// Illustration of graph
// Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
// Output: [2,4,5,6]
// Explanation: The given graph is shown above.
// Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
// Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
// Example 2:

// Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
// Output: [4]
// Explanation:
// Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 

// Constraints:

// n == graph.length
// 1 <= n <= 104
// 0 <= graph[i].length <= n
// 0 <= graph[i][j] <= n - 1
// graph[i] is sorted in a strictly increasing order.
// The graph may contain self-loops.
// The number of edges in the graph will be in the range [1, 4 * 104].
import java.util.ArrayList;
import java.util.List;

public class SafeNodes {
    class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> answer=new ArrayList<>();
        int[] state=new int[n];
        for(int i=0;i<n;i++){
            if(dfs(graph,i,state)){
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean dfs(int[][] graph,int node,int[] state){
        if(state[node]>0) return state[node]==2;

        state[node]=1;
        for(int next:graph[node]){
            if(1==state[next]||!dfs(graph,next,state)){
                return false;
            }
        }

        state[node]=2;
        return true;
    }
}
}
