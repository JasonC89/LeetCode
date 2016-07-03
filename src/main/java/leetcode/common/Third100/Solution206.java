package leetcode.common.Third100;

import leetcode.ListNode;

/**
 * Created by hchang on 6/29/16.
 * Reverse Linked List
 *
 * Reverse a singly linked list.
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
