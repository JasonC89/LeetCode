package leetcode.common;

/**
 * Created by Jason on 6/25/16.
 * Remove Duplicates from Sorted Array II
 *
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first
 five elements of nums being 1, 1, 2, 2 and 3. It doesn't
 matter what you leave beyond the new length.
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        boolean first = true;
        int slow = 0;
        int fast = 1;
        while(fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                if (first) {
                    first = false;
                    slow++;
                    nums[slow] = nums[fast];
                }
            } else {
                first = true;
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
