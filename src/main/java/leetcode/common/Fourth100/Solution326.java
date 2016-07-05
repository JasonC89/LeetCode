package leetcode.common.Fourth100;

/**
 * Created by Jason on 7/4/16.
 * Power of Three
 *
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?
 */
public class Solution326 {
    public boolean isPowerOfThree(int n) {
        return ( n>0 &&  1162261467%n==0);
    }
}
