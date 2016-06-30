package leetcode.common.Third100;

import leetcode.ListNode;

/**
 * Created by hchang on 6/29/16.
 * Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pointer = fake;
        while(pointer.next != null) {
            if (pointer.next.val == val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return fake.next;
    }
}
