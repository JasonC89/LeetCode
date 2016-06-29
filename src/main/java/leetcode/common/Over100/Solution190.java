package leetcode.common.Over100;

/**
 * Created by Jason on 6/28/16.
 * Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
public class Solution190 {
    public int reverseBits(int n) {
        int result = 0;
        int count = 0;
        while(count < 32) {
            count++;
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
}
