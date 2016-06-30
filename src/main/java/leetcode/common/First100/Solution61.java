package leetcode.common.First100;

import leetcode.ListNode;

/**
 * Created by hchang on 6/24/16.
 * Rotate List
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode pointer = head;
        int size = 0;
        while (pointer!= null) {
            size++;
            pointer = pointer.next;
        }

        k %= size;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(k > 0) {
            fast = fast.next;
            k--;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }
}
