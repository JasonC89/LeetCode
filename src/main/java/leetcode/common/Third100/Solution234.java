package leetcode.common.Third100;

import leetcode.ListNode;

/**
 * Created by hchang on 6/30/16.
 * Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode dummy = null;
        slow = slow.next;

        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = dummy;
            dummy = slow;
            slow = tmp;
        }
        slow = dummy;
        while (slow!=null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
