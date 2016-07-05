package leetcode.common.Fourth100;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Jason on 7/4/16.
 * Nested List Weight Sum
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

 Example 2:
 Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */
public class Solution339 {
    public int depthSum(List<NestedInteger> nestedList) {
        Stack<Iterator<NestedInteger>> stack = new Stack();
        int level = 1;
        int result = 0;
        stack.push(nestedList.iterator());
        while (!stack.isEmpty()) {
            if (stack.peek().hasNext()) {
                NestedInteger current = stack.peek().next();
                if (current.isInteger()) {
                    result += level * current.getInteger();
                } else {
                    stack.push(current.getList().iterator());
                    level++;
                }
            } else {
                stack.pop();
                level--;
            }
        }
        return result;
    }

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
}
