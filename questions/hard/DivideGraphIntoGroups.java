// 2493. Divide Nodes Into the Maximum Number of Groups
// Solved
// Hard
// Topics
// Companies
// Hint
// You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

// You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.

// Divide the nodes of the graph into m groups (1-indexed) such that:

// Each node in the graph belongs to exactly one group.
// For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
// Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.

 

// Example 1:


// Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
// Output: 4
// Explanation: As shown in the image we:
// - Add node 5 to the first group.
// - Add node 1 to the second group.
// - Add nodes 2 and 4 to the third group.
// - Add nodes 3 and 6 to the fourth group.
// We can see that every edge is satisfied.
// It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.
// Example 2:

// Input: n = 3, edges = [[1,2],[2,3],[3,1]]
// Output: -1
// Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
// It can be shown that no grouping is possible.
 

// Constraints:

// 1 <= n <= 500
// 1 <= edges.length <= 104
// edges[i].length == 2
// 1 <= ai, bi <= n
// ai != bi
// There is at most one edge between any pair of vertices.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DivideGraphIntoGroups {
    class Solution {
        public int magnificentSets(int n, int[][] edges) {
            // bfs -> will detect odd cycle (graph must be bipartite==not have an odd cycle)
            // for each component take the maximum
            // dfs -> to partition into components
            
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int node = 1; node <= n; node++) {
                graph.put(node, new ArrayList<>());
            }
            
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            
            Map<Integer, List<Integer>> components = new HashMap<>();
            Set<Integer> visited = new HashSet<>();
            int component = 1;
            for (int node = 1; node <= n; node++) {
                if(visited.contains(node)) continue;
                visited.add(node);
                components.put(component, new ArrayList<>());
                dfsComponents(component++, node, graph, components, visited);    
            }
            int[] componentsMaxTravel = new int[component];
            int finalRes = 0;
            for(int comp = 1; comp < component; comp++) {
                for (int compNode : components.get(comp)) {
                    
                    int compRes = bfs(compNode, graph);
                    if(compRes == -1) return -1;
                    componentsMaxTravel[comp] = Math.max(componentsMaxTravel[comp], compRes);
                }
                finalRes += componentsMaxTravel[comp];
            }
    
            return finalRes;
            
        }
    
        private void dfsComponents(int component, int node, Map<Integer, List<Integer>> graph, Map<Integer, List<Integer>> components, Set<Integer> visited) {
            components.get(component).add(node);
            for (int neighbor : graph.get(node)) {
                // happens when there is more than one spanning tree. I.E you can arrive at a node in more than one way
                if(visited.contains(neighbor)) continue;
                visited.add(neighbor);
                dfsComponents(component, neighbor, graph, components, visited);
            }
        }
    
        private int bfs(int node, Map<Integer, List<Integer>> graph) {
            int reach = 0;
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> curLevel = new HashSet<>();
            
            queue.offer(node);
            visited.add(node);
            
            while (!queue.isEmpty()) {
                int n = queue.size();
                Set<Integer> nextLevel = new HashSet<>();
    
                
                
                for (int i = 0; i < n; i++) {
                    int curNode = queue.poll();
    
                    for(int neighbor : graph.get(curNode)) {
                        if(curLevel.contains(neighbor)) return -1; // Colored with different color == not bipartite
                        if(visited.contains(neighbor)) continue;
                        nextLevel.add(neighbor);
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
    
                curLevel = nextLevel;
                reach++;
            }
            
            return reach;
        }
    }   
}
