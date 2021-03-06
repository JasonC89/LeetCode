package leetcode.common.Second100;

import java.util.Stack;

/**
 * Created by Jason on 6/27/16.
 * Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class Solution155 {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public Solution155() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int current = stack.pop();
        if (minStack.isEmpty() || current == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
