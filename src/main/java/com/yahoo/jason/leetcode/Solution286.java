package com.yahoo.jason.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hchang on 5/25/16.
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

 */
public class Solution286 {
    public void wallsAndGates(int[][] rooms) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (rooms == null || rooms.length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length) {
                    if (rooms[x][y] > rooms[current[0]][current[1]] + 1) {
                        rooms[x][y] = rooms[current[0]][current[1]] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
