package leetcode.stars;

/**
 * Created by hchang on 6/14/16.
 * Number of Connected Components in an Undirected Graph
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to find the number
 * of connected components in an undirected graph.

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
 You can assume that no duplicate edges will appear in edges. Since all
 edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 together in edges.
 */
public class Solution323 {
    private int[] parents;
    private int[] rankings;

    public int countComponents(int n, int[][] edges) {
        parents = new int[n];
        rankings = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rankings[i] = 1;
        }
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                n--;
            }
        }
        return n;
    }

    private int find(int index) {
        while(index != parents[index]) {
            index = parents[index];
        }
        return index;
    }

    private boolean union(int i, int j) {
        int parent1 = find(i);
        int parent2 = find(j);
        if (parent1 == parent2) {
            return false;
        }
        if (rankings[parent1] > rankings[parent2]) {
            parents[parent2] = parent1;
            rankings[parent1] += parents[parent2];
        } else {
            parents[parent1] = parent2;
            rankings[parent2] += parents[parent1];
        }
        return true;
    }
}
