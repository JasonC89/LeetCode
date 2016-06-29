package leetcode.common.Over100;

/**
 * Created by Jason on 6/28/16.
 * Rotate Array
 *
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);
    }

    private void rotate(int [] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
