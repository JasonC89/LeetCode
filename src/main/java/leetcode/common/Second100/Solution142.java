package leetcode.common.Second100;

import leetcode.ListNode;

/**
 * Created by Jason on 6/27/16.
 * 142. Linked List Cycle II
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            if(fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }else{
                return null;
            }
            if(fast == slow) break;
        }
        if(fast == null) return null;
        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
