package leetcode.stars;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hchang on 6/9/16.
 * LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the
 key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity,
 it should invalidate the least recently used item before inserting a new item.
 */


public class Solution146 {
    private int capacity = 0;
    private int count = 0;
    private Node head = null;
    private Node tail = null;
    private Map<Integer, Node> map;

    public Solution146(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        addHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            addHead(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            if (count == capacity) {
                map.remove(tail.pre.key);
                remove(tail.pre);
                count--;
            }
            addHead(node);
            count++;
        }
    }

    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private void addHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
    }

    private class Node{
        public int key;
        public int value;
        public Node pre;
        public Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static public void main(String[] args) {
        Solution146 solution146 = new Solution146(1);
        solution146.set(2, 1);
        solution146.get(1);
    }
}
