package leetcode.stars;

import java.util.Stack;

/**
 * Created by hchang on 6/7/16.
 * Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        for (int i = 0; i <= heights.length; i++) {
            int current = i == heights.length ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > current) {
                int height = heights[stack.pop()];
                result = Math.max(result, height * (stack.isEmpty()? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        solution84.largestRectangleArea(new int[]{1, 1});
    }
}
