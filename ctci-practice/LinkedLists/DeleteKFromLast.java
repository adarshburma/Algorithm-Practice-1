package org.practice.courses.courseapi;

public class DeleteKFromLast {

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

    static void removeKFromLast(int k){
        Node ptr1 = head;
        Node ptr2 = head;

        for(int i = 0 ; i < k+1; i++){
            if(ptr2 != null){
                ptr2 = ptr2.next;
            }
        }

        while(ptr2 != null){
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }

        ptr1.next = ptr1.next.next;
    }

    public static void main(String[] args){
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        insert(6);
        insert(7);

        removeKFromLast(3);
        print();

    }

}
