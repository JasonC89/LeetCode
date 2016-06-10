package leetcode.stars;

/**
 * Created by hchang on 6/9/16.
 * Single Number II
 *
 * Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity.
 Could you implement it without using extra memory?
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int c : nums) {
            int tmp = (a & ~b & ~c) | (~a & b & c);
            b = (~a & ~b & c) | (~a & b & ~c);
            a = tmp;
        }
        return a | b;
    }
}
