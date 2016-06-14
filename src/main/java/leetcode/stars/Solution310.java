package leetcode.stars;

import java.util.*;

/**
 * Created by hchang on 6/13/16.
 * Minimum Height Trees
 *
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]
 */
public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> neighbors = new ArrayList();
        for (int i = 0; i < n; i++) {
            neighbors.add(new HashSet());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (neighbors.get(i).size() <= 1) {
                leaves.add(i);
            }
        }
        while(n > 2) {
            List<Integer> newLeaves = new ArrayList();
            n -= leaves.size();
            for (int leaf : leaves) {
                int next = neighbors.get(leaf).iterator().next();
                neighbors.get(next).remove(leaf);
                if (neighbors.get(next).size() == 1) {
                    newLeaves.add(next);
                }
            }
            leaves.clear();
            leaves.addAll(newLeaves);
        }
        return leaves;
    }
}
