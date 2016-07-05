package leetcode.common.Fourth100;

/**
 * Created by Jason on 7/4/16.
 * Sum of Two Integers
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.


 */
public class Solution371 {
    public int getSum(int a, int b) {
        if(b == 0){
            return a;
        }
        int sum,carry;
        sum = a^b;
        carry = (a&b)<<1;
        return getSum(sum,carry);
    }
}
