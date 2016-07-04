package leetcode.common.Third100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 7/2/16.
 * Course Schedule
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        Map<Integer, List<Integer>> neighbors = new HashMap();
        for (int[] prerequisite : prerequisites) {
            if (!neighbors.containsKey(prerequisite[0])) {
                neighbors.put(prerequisite[0], new ArrayList());
            }
            neighbors.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(visited, neighbors, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] visited, Map<Integer, List<Integer>> neighbors, int index) {
        visited[index] = 1;
        if (neighbors.containsKey(index)) {
            for (int next : neighbors.get(index)) {
                if (visited[next] == 1) {
                    return false;
                } else if (visited[next] == 0) {
                    if (!dfs(visited, neighbors, next)) {
                        return false;
                    }
                }
            }
        }
        visited[index] = 2;
        return true;
    }
}
