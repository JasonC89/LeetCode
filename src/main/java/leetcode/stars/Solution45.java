package leetcode.stars;

/**
 * Created by hchang on 6/7/16.
 * Jump Game II
 * Given an array of non-negative integers,
 * you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.
 */
public class Solution45 {
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int current = 0;
        while(current <= max) {
            if (max >= nums.length) {
                return step;
            }
            step++;
            int newMax = max;
            while(current <= max) {
                newMax = Math.max(current+nums[current], newMax);
                current++;
            }
            max = newMax;
        }
        return step;
    }
}
