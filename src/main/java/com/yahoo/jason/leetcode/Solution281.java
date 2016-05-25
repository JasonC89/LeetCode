package com.yahoo.jason.leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hchang on 5/25/16.
 * Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

 [1,2,3]
 [4,5,6,7]
 [8,9]
 It should return [1,4,8,2,5,9,3,6,7].
 */
public class Solution281 {
    private Iterator<Integer> iterator1;
    private Iterator<Integer> iterator2;
    private boolean first = true;

    public Solution281(List<Integer> v1, List<Integer> v2) {
        if (v1 != null) {
            iterator1 = v1.iterator();
        }
        if (v2 != null) {
            iterator2 = v2.iterator();
        }
    }

    public int next() {
        if (hasNext()) {
            int result;
            if (first) {
                result = iterator1.next();
                first = false;
            } else {
                result = iterator2.next();
                first = true;
            }
            return result;
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        if (first) {
            if (iterator1.hasNext()) {
                return true;
            } else {
                first = false;
                return iterator2.hasNext();
            }
        } else {
            if (iterator2.hasNext()) {
                return true;
            } else {
                first = true;
                return iterator1.hasNext();
            }
        }
    }
}
