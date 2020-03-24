package com.example.challenges.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.get(key)==null) {
            return -1;
        }

        //move to tail
        Node t = map.get(key);

        removeNode(t);
        addNodeAtLast(t);

        return t.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node t = map.get(key);
            t.value = value;

            //move to tail
            removeNode(t);
            addNodeAtLast(t);
        } else {
            if(map.size() >= capacity) {
                //delete head
                map.remove(head.key);
                removeNode(head);
            }

            //add to tail
            Node node = new Node(key, value);
            addNodeAtLast(node);
            map.put(key, node);
        }
    }

    private void removeNode(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addNodeAtLast(Node node) {
        if(head == null) {
            head = node;
        } else {
            Node last = tail;
            last.next = node;
            node.prev = last;
        }
        tail = node;
    }

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

        System.out.println("---------------");
        cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
