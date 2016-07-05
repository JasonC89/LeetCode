package leetcode.common.Third100;

import java.util.Iterator;

/**
 * Created by Jason on 7/3/16.
 * Peeking Iterator
 *
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

 Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

 Call next() gets you 1, the first element in the list.

 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

 You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
 */
public class Solution284 implements Iterator<Integer> {

    Integer cache = null;
    Iterator<Integer> iterator;

    public Solution284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            cache = this.iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int tmp = cache;
        if (this.iterator.hasNext()) {
            cache = this.iterator.next();
        } else {
            cache = null;
        }
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return cache != null;
    }
}
