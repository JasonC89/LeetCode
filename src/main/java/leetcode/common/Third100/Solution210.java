package leetcode.common.Third100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 7/2/16.
 * Course Schedule II
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course
 order is [0,1,2,3]. Another correct ordering is[0,2,1,3].


 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] array = new int[numCourses];
        Map<Integer, List<Integer>> neighbors = new HashMap();
        List<Integer> result = new ArrayList();
        for (int[] prerequisite : prerequisites) {
            if (!neighbors.containsKey(prerequisite[1])) {
                neighbors.put(prerequisite[1], new ArrayList());
            }
            neighbors.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(visited, neighbors, i, result)) {
                return new int[0];
            }
        }
        for (int i = 0; i < numCourses; i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    private boolean dfs(int[] visited, Map<Integer, List<Integer>> neighbors, int index, List<Integer> result) {
        visited[index] = 1;
        if (neighbors.containsKey(index)) {
            for (int next : neighbors.get(index)) {
                if (visited[next] == 1) {
                    return false;
                } else if (visited[next] == 0) {
                    if (!dfs(visited, neighbors, next, result)) {
                        return false;
                    }
                }
            }
        }
        visited[index] = 2;
        result.add(0, index);
        return true;
    }
}
