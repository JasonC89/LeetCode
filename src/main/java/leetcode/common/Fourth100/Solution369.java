package leetcode.common.Fourth100;

import leetcode.ListNode;

/**
 * Created by Jason on 7/5/16.
 * Plus One Linked List
 *
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4
 */
public class Solution369 {
    public ListNode plusOne(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pointer = head;
        ListNode candidate = fake;
        while (pointer != null) {
            if (pointer.val != 9) {
                candidate = pointer;
            }
            pointer = pointer.next;
        }

        candidate.val++;
        pointer = candidate.next;
        while (pointer != null) {
            pointer.val = 0;
            pointer = pointer.next;
        }
        if (candidate == fake) {
            return fake;
        } else {
            return fake.next;
        }
    }
}
