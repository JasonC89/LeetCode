package leetcode.common.Third100;

/**
 * Created by Jason on 7/3/16.
 * First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


 */
public class Solution278 {
    public int firstBadVersion(int n) {
        return helper(1, n);
    }

    private int helper(int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return helper(start, mid);
        } else {
            return helper(mid+1, end);
        }
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
