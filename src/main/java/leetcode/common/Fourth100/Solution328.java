package leetcode.common.Fourth100;

import leetcode.ListNode;

/**
 * Created by Jason on 7/4/16.
 * Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddFake = new ListNode(0);
        ListNode evenFake = new ListNode(0);
        ListNode oddPointer = oddFake;
        ListNode evenPointer = evenFake;
        ListNode pointer = head;
        boolean odd = true;
        while(pointer != null) {
            if (odd) {
                oddPointer.next = pointer;
                oddPointer = oddPointer.next;
            } else {
                evenPointer.next = pointer;
                evenPointer = evenPointer.next;
            }
            pointer = pointer.next;
            odd = !odd;
        }
        oddPointer.next = evenFake.next;
        evenPointer.next = null;
        return oddFake.next;
    }
}
