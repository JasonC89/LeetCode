package leetcode.stars;

import java.util.*;

/**
 * Created by Jason on 6/12/16.
 * Graph Valid Tree
 *
 * Given n nodes labeled from 0 to n - 1 and a list of
 * undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make
 * up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

 Hint:

 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class Solution261 {
    public boolean validTree(int n, int[][] edges) {
        List<Set<Integer>> neighbors = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            neighbors.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (visited[current]) {
                return false;
            }
            visited[current] = true;
            for (int neighbor : neighbors.get(current)) {
                queue.offer(neighbor);
                neighbors.get(neighbor).remove(current);
            }
        }
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
