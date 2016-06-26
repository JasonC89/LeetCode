package leetcode.common;

import leetcode.ListNode;

/**
 * Created by Jason on 6/25/16.
 * Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode left = leftHead;
        ListNode right = rightHead;
        ListNode pointer = head;
        while(pointer != null) {
            if (pointer.val < x) {
                left.next = pointer;
                left = left.next;
            } else {
                right.next = pointer;
                right = right.next;
            }
            pointer = pointer.next;
        }
        right.next = null;
        if (leftHead.next == null) {
            return rightHead.next;
        }
        left.next = rightHead.next;
        return leftHead.next;
    }
}
