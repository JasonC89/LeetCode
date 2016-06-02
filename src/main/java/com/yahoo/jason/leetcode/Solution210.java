package com.yahoo.jason.leetcode;

import java.util.Stack;

/**
 * Created by hchang on 6/1/16
 *
 *
There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].


 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] visited = new int[numCourses];
        boolean[][] adjs = new boolean[numCourses][numCourses];
        Stack<Integer> stack = new Stack();
        for (int[] prerequisite : prerequisites) {
            adjs[prerequisite[1]][prerequisite[0]] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]==0 && !dfs(visited, adjs, i, stack)) {
                return result;
            }
        }
        for(int i =0; i < numCourses; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean dfs(int[] visited, boolean[][] adjs, int index, Stack<Integer> stack) {
        visited[index] = 1;
        for (int i = 0; i < visited.length; i++) {
            if (adjs[index][i]) {
                if (visited[i] == 1) {
                    return false;
                }
                if (visited[i] == 0 && !dfs(visited, adjs, i, stack)) {
                    return false;
                }
            }
        }
        stack.push(index);
        visited[index] = 2;
        return true;
    }

    public static void main(String[] args) {
        Solution210 solution210 = new Solution210();
        solution210.findOrder(2, new int[][]{{1,0}});
    }
}
