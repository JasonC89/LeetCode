package leetcode.common.First100;

import leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Jason on 6/21/16.
 * Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode node : lists) {
            heap.offer(node);
        }
        ListNode fake = new ListNode(0);
        ListNode pointer = fake;
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            pointer.next = node;
            pointer = pointer.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return fake.next;
    }
}
