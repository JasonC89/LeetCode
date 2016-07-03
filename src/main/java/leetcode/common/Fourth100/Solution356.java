package leetcode.common.Fourth100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hchang on 6/30/16.
 * Line Reflection
 *
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.

 Follow up:
 Could you do better than O(n2)?

 Hint:

 Find the smallest and largest x-value for all points.
 If there is a line then it should be at y = (minX + maxX) / 2.
 For each point, make sure that it has a reflected point in the opposite side.
 */
public class Solution356 {
    public boolean isReflected(int[][] points) {
        Set<Integer> pointSet = new HashSet<>();
        int sum;
        int maxX, minX;

        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        for(int[] point:points) {
            maxX = Math.max(maxX, point[ 0 ]);
            minX = Math.min(minX, point[ 0 ]);
            pointSet.add(Arrays.hashCode(point));
        }

        sum = maxX+minX;
        for(int[] point:points) {
            if(!pointSet.contains(Arrays.hashCode(new int[]{sum-point[ 0 ], point[ 1 ]}))) {
                return false;
            }
        }
        return true;
    }
}

