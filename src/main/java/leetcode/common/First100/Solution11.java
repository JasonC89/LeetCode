package leetcode.common.First100;

/**
 * Created by hchang on 6/21/16.
 * Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which
 * together with x-axis forms a container, such that the
 * container contains the most water.

 Note: You may not slant the container.
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
