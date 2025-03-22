package questions.medium;

// 2685. Count the Number of Complete Components
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

// Return the number of complete connected components of the graph.

// A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

// A connected component is said to be complete if there exists an edge between every pair of its vertices.

 

// Example 1:



// Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
// Output: 3
// Explanation: From the picture above, one can see that all of the components of this graph are complete.
// Example 2:



// Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
// Output: 1
// Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 

// Constraints:

// 1 <= n <= 50
// 0 <= edges.length <= n * (n - 1) / 2
// edges[i].length == 2
// 0 <= ai, bi <= n - 1
// ai != bi
// There are no repeated edges.


public class ConnectedComponentGraphs {

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Create adjacency list (Better than using matrix)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // BFS traversal
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                if (bfs(i, adj, visited, component)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    public boolean bfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        component.add(node);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    component.add(neighbor);
                }
            }
        }

        // Check if the subgraph is a complete component
        int size = component.size();
        for (int u : component) {
            if (adj.get(u).size() != size - 1) {  // A complete component must have size-1 edges per node
                return false;
            }
        }

        return true;
    }

    
}

}
