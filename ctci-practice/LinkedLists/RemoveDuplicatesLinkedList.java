package org.practice.courses.courseapi;

public class RemoveDuplicatesLinkedList {
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

    /* Remove duplicates using an extra pointer*/

    static void removeDuplicatesWithoutBuffer(){
        Node current = head;
        while (current != null){
            Node runner = current;
            while (runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    public static void main(String args[]){
        insert(1);
        insert(2);
        insert(1);
        insert(3);
        insert(4);
        insert(3);

        print();

        removeDuplicatesWithoutBuffer();

        print();
    }
}
