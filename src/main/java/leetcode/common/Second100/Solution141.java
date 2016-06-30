package leetcode.common.Second100;

import leetcode.ListNode;

/**
 * Created by Jason on 6/26/16.
 * Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
