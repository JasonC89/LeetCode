package leetcode.common;

import leetcode.ListNode;

/**
 * Created by hchang on 6/22/16.
 * Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode last = fake;
        int times = k;
        while(times >= 0) {
            if (last == null) {
                return head;
            }
            last = last.next;
            times--;
        }

        ListNode first = head;
        ListNode second = head.next;
        while(second != last) {
            ListNode newSecond = second.next;
            second.next = first;
            first = second;
            second = newSecond;
        }
        fake.next = first;
        head.next = reverseKGroup(last,k);
        return fake.next;
    }
}
