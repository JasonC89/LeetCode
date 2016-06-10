package leetcode.stars;

/**
 * Created by Jason on 6/8/16.
 * Candy
 *
 * There are N children standing in a line.
 * Each child is assigned a rating value.

 You are giving candies to these children
 subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Solution135 {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        for (int i = 1; i < result.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                result[i] = Math.max(result[i], result[i-1] + 1);
            }
        }
        for (int i = result.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
        }
        int total = 0;
        for (int num : result) {
            total += num;
        }
        return total;
    }
}
