package org.practice.courses.courseapi;

public class PartitionLinkedList {
    static Node head;
    static class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    static void insert(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void print(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println();
    }

    static void print(Node node){
        Node current = node;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    static Node partition(Node node , int x){
        Node start = node;
        Node tail = node;

        while(node != null ){
            Node next = node.next;
            if(node.data < x){
                node.next = start;
                start = node;
            } else {
                tail.next = node;
                tail = node;
            }

            node = next;
        }

        tail.next = null;

        return start;

    }

    public static void main(String[] args){
        insert(3);
        insert(7);
        insert(2);
        insert(9);
        insert(1);
        insert(5);
        insert(4);
        insert(5);

        print();
        print(partition(head,5));
    }
}
