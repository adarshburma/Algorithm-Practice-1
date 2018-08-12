package org.practice.courses.courseapi;

public class LinkedListLoop {
    Node head;
    static class Node{
        Node next;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void detectAndRemoveLoop(Node head){
        Node fast = head;
        Node slow = head;
        while(slow != null  && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                fast.next = null;
            }
        }
    }

    public static void main(String[] args){
        LinkedListLoop loop = new LinkedListLoop();
        loop.head = new Node(1);
        loop.head.next = new Node(3);
        loop.head.next.next = new Node(8);
        loop.head.next.next.next = new Node(10);
        loop.head.next.next.next.next = new Node(12);

        //Create a loop:

        loop.head.next.next.next.next.next =  loop.head.next;
        loop.detectAndRemoveLoop(loop.head);
        loop.printList();

    }
}
