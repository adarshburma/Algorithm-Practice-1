package com.iheartmedia.salesforce.config.handler;

public class CopyLinkedList {
   static Node head;
    static class Node{
        Node next;
        int data;
        Node random;

        Node(int data){
            this.data = data;
        }
    }

    static void insert(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void printOriginal(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next.next;
        }
        System.out.println();
    }

    static void setRandomPointers(){
        Node current = head;
        while(current.next != null){
            current.random = current.next.next;
            current = current.next;
        }
    }

    static void printCopy(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.random;
        }
        System.out.println();
    }

    static void insertBetween(){
        Node current = head;
        Node next;
        while(current != null){
            next = current.next;
            Node newNode =  new Node(current.data);
            newNode.next = next;
            current.next = newNode;
            current = current.next.next;
        }
    }

    public static void main(String[] args){
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        insertBetween();
        printOriginal();
        setRandomPointers();
        printCopy();

    }
}
