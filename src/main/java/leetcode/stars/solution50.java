package leetcode.stars;

/**
 * Created by hchang on 6/7/16.
 * Pow(x, n)
 * Implement pow(x, n).
 */
public class solution50 {
    public double myPow(double x, int n) {
        double ans= 1;
        for(long i = Math.abs((long)n); i > 0; i = i >> 1, x *=x)
            if((i & 1) == 1) ans *= x;
        return n > 0 ? ans : 1/ans;
    }
}
