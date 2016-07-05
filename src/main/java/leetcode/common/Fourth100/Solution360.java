package leetcode.common.Fourth100;

/**
 * Created by Jason on 7/4/16.
 * Sort Transformed Array
 *
 * Given a sorted array of integers nums and integer
 * values a, b and c. Apply a function of the form f(x)
 * = ax2 + bx + c to each element x in the array.

 The returned array must be in sorted order.

 Expected time complexity: O(n)

 Example:
 nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

 Result: [3, 9, 15, 33]

 nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

 Result: [-23, -5, 1, 7]
 */
public class Solution360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = a >= 0? nums.length-1 : 0;
        while (left <= right) {
            if (a >= 0) {
                result[index--] = quad(nums[left], a, b, c) >= quad(nums[right], a, b, c) ? quad(nums[left++], a, b, c) : quad(nums[right--], a, b, c);
            } else {
                result[index++] = quad(nums[left], a, b, c) >= quad(nums[right], a, b, c) ? quad(nums[right--], a, b, c) : quad(nums[left++], a, b, c);
            }
        }
        return result;
    }

    private int quad(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}
