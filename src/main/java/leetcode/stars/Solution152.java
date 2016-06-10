package leetcode.stars;

/**
 * Created by hchang on 6/9/16.
 * Maximum Product Subarray
 *
 * Find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int currentMax = Integer.MIN_VALUE;
        int currentMin = Integer.MAX_VALUE;
        for (int num : nums) {
            int max;
            int min;
            if (num >= 0) {
                max = currentMax > 0 ? currentMax * num : num;
                min = currentMin < 0 ? currentMin * num : num;
            } else {
                max = currentMin < 0 ? currentMin * num : num;
                min = currentMax > 0 ? currentMax * num : num;
            }
            result = Math.max(max, result);
            currentMax = max;
            currentMin = min;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        solution152.maxProduct(new int[] {-4, -3, -2});
    }
}
