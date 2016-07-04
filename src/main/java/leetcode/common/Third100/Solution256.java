package leetcode.common.Third100;

/**
 * Created by Jason on 7/3/16.
 * Paint House
 *
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.
 */
public class Solution256 {
    public int minCost(int[][] costs) {
        int red = 0;
        int blue = 0;
        int green = 0;
        for (int[] cost : costs) {
            int newRed = Math.min(blue, green) + cost[0];
            int newBlue = Math.min(red, green) + cost[1];
            int newGreen = Math.min(red, blue) + cost[2];
            red = newRed;
            blue = newBlue;
            green = newGreen;
        }
        return Math.min(Math.min(red, blue), green);
    }
}
