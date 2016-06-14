package leetcode.stars;

import java.util.*;

/**
 * Created by Jason on 6/12/16.
 * Number of Islands II
 *
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0
 We return the result as an array: [1, 1, 2, 3]

 Challenge:

 Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class Solution305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parents = new int[m*n];
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        Set<Integer> visited = new HashSet();
        List<Integer> result = new ArrayList();
        int count = 0;

        for (int i = 0; i < m * n; i++){
            parents[i] = i;
        }

        for (int[] position : positions) {
            int index = position[0] * n + position[1];
            visited.add(index);
            count++;
            for (int[] direction : directions) {
                int x = position[0] + direction[0];
                int y = position[1] + direction[1];
                int newIndex = x * n + y;
                if (x >= 0 && y >= 0 && x < m && y < n && visited.contains(newIndex)) {
                    if (union(index, newIndex, parents)) {
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private int find(int index, int[] parents) {
        while(index != parents[index]) {
            index = parents[index];
        }
        return index;
    }

    private boolean union(int i, int j, int[] parents) {
        int parent1 = find(i, parents);
        int parent2 = find(j, parents);
        if (parent1 == parent2) {
            return false;
        }
        parents[parent1] = parent2;
        return true;
    }
}
