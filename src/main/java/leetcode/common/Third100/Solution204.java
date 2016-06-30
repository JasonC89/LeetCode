package leetcode.common.Third100;

import java.util.Arrays;

/**
 * Created by hchang on 6/29/16.
 * Count Primes
 *
 * Description:

 Count the number of prime numbers less than a non-negative number, n.


 */
public class Solution204 {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] result = new boolean[n];
        Arrays.fill(result, true);
        result[1] = false;
        result[0] = false;
        for (int i = 1; i < n; i++) {
            if (!result[i]) {
                continue;
            }
            int j = 2;
            while(i * j < n) {
                result[i*j] = false;
                j++;
            }
        }
        int counter = 0;
        for (boolean b : result) {
            if (b) {
                counter++;
            }
        }
        return counter;
    }
}
