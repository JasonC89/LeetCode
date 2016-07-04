package leetcode.common.Third100;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Jason on 7/2/16.
 * Flatten 2D Vector
 *
 * Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

 Hint:

 How many variables do you need to keep track?
 Two variables is all you need. Try with x and y.
 Beware of empty rows. It could be the first few rows.
 To write correct code, think about the invariant to maintain. What is it?
 The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
 Not sure? Think about how you would implement hasNext(). Which is more complex?
 Common logic in two different places should be refactored into a common method.
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
