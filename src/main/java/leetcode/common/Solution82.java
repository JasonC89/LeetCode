package leetcode.common;

import leetcode.ListNode;

/**
 * Created by Jason on 6/25/16.
 * Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.

 Show Tags

 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode slow = fake;
        ListNode fast = head.next;
        ListNode tail = head;
        boolean hasSame = false;
        while(fast != null) {
            if (slow.next.val == fast.val) {
                hasSame = true;
            } else {
                if (hasSame) {
                    slow.next = fast;
                } else {
                    slow = slow.next;
                }
            }
            fast = fast.next;
            tail = tail.next;
        }

        if (!hasSame) {
            slow.next = tail;
        } else {
            slow.next = null;
        }
        return fake.next;
    }
}
