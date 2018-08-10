package com.ihm.automation.utils.uputils.fulfillment;

public class LinkedList {

    Node head;

    public class Node{
        Node next;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    public void insert(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node reverse(Node node){

        Node current = node;
        Node prev = null;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        node = prev;
        return node;
    }

    public int pop(){
        Node current = head;
        int poped = 0;
        while(current != null){
            System.out.println(current.data);
            if(current.next.next != null){
                System.out.println(current.data);
                poped = current.next.data;
                current.next = null;
            }
            current = current.next;
        }

        return poped;
    }

    public void printListFrom(Node node) {
        Node current = node;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
