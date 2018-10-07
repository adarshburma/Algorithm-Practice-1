package org.practice.courses.courseapi;

import java.util.HashMap;

public class LRU2 {
    static class Node{
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node end;
    int capacity;

    LRU2(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;
    }

    public void remove(Node n){
        if(n.pre != null){
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if(n.next != null){
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if(head != null){
            head.pre = n;
        }

        head = n;

        if(end == null){
            end = head;
        }
    }

    public void set(int key, int val){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
        }else{
            Node created = new Node(key, val);
            if(map.size() >= capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }

    public static void main(String[] args){
        LRU2 cache = new LRU2(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.set(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.set(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
