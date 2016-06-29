package leetcode.common.First100;

/**
 * Created by Jason on 6/25/16.
 * Sort Colors
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }
        int index = 0;
        while(zero > 0) {
            nums[index] = 0;
            index++;
            zero--;
        }
        while(one > 0) {
            nums[index] = 1;
            index++;
            one--;
        }
        while(two > 0) {
            nums[index] = 2;
            index++;
            two--;
        }
    }

}
