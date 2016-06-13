package leetcode.stars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jason on 6/12/16.
 * Best Meeting Point
 *
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 For example, given three people living at (0,0), (0,4), and (2,2):

 1 - 0 - 0 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

 Show Hint
 Show Company Tags
 Show Tags
 Show Similar Problems

 */
public class Solution296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    horizontal.add(j);
                    vertical.add(i);
                }
            }
        }
        return getDistance(horizontal) + getDistance(vertical);
    }

    private int getDistance(List<Integer> list) {
        Collections.sort(list);
        int start = 0;
        int end = list.size()-1;
        int result = 0;
        while(start < end) {
            result += list.get(start++) + list.get(end--);
        }
        return result;
    }
}
