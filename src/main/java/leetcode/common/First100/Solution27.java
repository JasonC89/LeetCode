package leetcode.common.First100;

/**
 * Created by hchang on 6/22/16.
 * Remove Element
 *
 * Given an array and a value, remove all instances of that value in place
 * and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = -1;
        int fast = 0;
        while(fast < nums.length) {
            if (nums[fast] != val) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
