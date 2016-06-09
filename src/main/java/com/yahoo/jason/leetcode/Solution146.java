package com.yahoo.jason.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hchang on 6/2/16.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Show Company Tags
 Show Tags

 */
public class Solution146 {
    private int capacity = 0;
    private int count = 0;
    private DNode head;
    private DNode tail;
    private Map<Integer, DNode> map;

    public Solution146(int capacity) {
        this.capacity = capacity;
        head = new DNode(0,0);
        tail = new DNode(0,0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap();
    }

    public int get(int key) {
        DNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        addHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        DNode node = map.get(key);
        if (node != null) {
            node.value = value;
        } else {
            node = new DNode(key, value);
            if (count < this.capacity) {
                addTail(node);
                count++;
            } else {
                remove(tail.pre);
                addHead(node);
            }
        }
    }

    private void addHead(DNode node) {
        DNode old = head.next;
        head.next = node;
        node.pre = head;
        node.next = old;
        old.pre = node;
        map.put(node.key, node);
    }

    private void addTail(DNode node) {
        DNode old = tail.pre;
        old.next = node;
        node.pre = old;
        node.next = tail;
        tail.pre = node;
        map.put(node.key, node);
    }

    private void remove(DNode node) {
        map.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private class DNode {
        public int key;
        public int value;
        public DNode pre;
        public DNode next;
        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
