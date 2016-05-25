package com.yahoo.jason.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hchang on 5/25/16.
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class Solution323 {

    public int countComponents(int n, int[][] edges) {
        Map<Integer, Integer> parents = new HashMap();
        for (int i = 0; i < n; i++) {
            parents.put(i, i);
        }
        int count = n;
        for (int[] edge : edges) {
            int parent1 = find(edge[0], parents);
            int parent2 = find(edge[1], parents);
            if (parent1 != parent2) {
                parents.put(parent1, parent2);
                count--;
            }
        }

        return count;
    }

    private int find(int x, Map<Integer, Integer> parents) {
        int parent = x;
        while(parent != parents.get(parent)) {
            parent = parents.get(parent);
        }
        return parent;
    }

}
