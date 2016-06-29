package leetcode.common.First100;

import leetcode.ListNode;

/**
 * Created by Jason on 6/21/16.
 * Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pointer = fake;
        while (pointer.next != null && pointer.next.next != null) {
            ListNode first = pointer.next;
            ListNode second = first.next;
            ListNode third = second.next;
            pointer.next = second;
            second.next = first;
            first.next = third;
            pointer = pointer.next.next;
        }
        return fake.next;
    }
}
