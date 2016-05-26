package com.yahoo.jason.leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hchang on 5/25/16.
 * Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */

public class Solution251 implements Iterator<Integer> {
    private Iterator<List<Integer>> listIterator;
    private Iterator<Integer> integerIterator;

    public Solution251(List<List<Integer>> vec2d) {
        if (vec2d != null) {
            listIterator = vec2d.iterator();
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return integerIterator.next();
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        if (listIterator == null) {
            return false;
        }
        while (listIterator.hasNext() && (integerIterator == null || !integerIterator.hasNext())) {
            integerIterator = listIterator.next().iterator();
        }
        if (integerIterator == null) {
            return false;
        }
        return integerIterator.hasNext();
    }
}
