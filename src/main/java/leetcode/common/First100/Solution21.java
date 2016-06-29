package leetcode.common.First100;

import leetcode.ListNode;

/**
 * Created by Jason on 6/21/16.
 * Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode pointer = fakeHead;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if (l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }
        return fakeHead.next;
    }
}
