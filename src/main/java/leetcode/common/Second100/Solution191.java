package leetcode.common.Second100;

/**
 * Created by hchang on 6/29/16.
 * Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int result = 0;
        while(n != 0) {
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }
}
