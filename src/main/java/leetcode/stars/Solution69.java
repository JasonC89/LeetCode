package leetcode.stars;

/**
 * Created by hchang on 6/7/16.
 * Sqrt(x)
 *
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public int newton(int x) {
        int r = x;
        while (r*r > x)
            r = ((r + x/r) / 2) | 0;
        return r;
    }
}
