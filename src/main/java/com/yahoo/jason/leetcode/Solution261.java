package com.yahoo.jason.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hchang on 5/26/16.
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

 Show Hint
 Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class Solution261 {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Integer> parents = new HashMap();
        for (int i = 0; i < n; i++) {
            parents.put(i, i);
        }

        for (int[] edge : edges) {
            int parent1 = find(edge[0], parents);
            int parent2 = find(edge[1], parents);
            if (parent1 != parent2) {
                parents.put(parent1, parent2);
                n--;
            } else {
                return false;
            }
        }
        return n == 1;
    }

    private int find(int node, Map<Integer, Integer> parents) {
        while(node != parents.get(node)) {
            node = parents.get(node);
        }
        return node;
    }
}
