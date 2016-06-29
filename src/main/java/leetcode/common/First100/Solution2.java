package leetcode.common.First100;

import leetcode.ListNode;

/**
 * Created by hchang on 6/21/16.
 * Add Two Numbers
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode pointer = fakeHead;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int current = carry;
            if (l1 != null) {
                current += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                current += l2.val;
                l2 = l2.next;
            }
            pointer.next = new ListNode(current % 10);
            carry = current / 10;
            pointer = pointer.next;
        }
        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }
        return fakeHead.next;
    }
}
