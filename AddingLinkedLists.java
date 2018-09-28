package org.practice.courses.courseapi;

public class AddingLinkedLists {
    static Node head;
    static Node head1;
    static Node res;
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

    static void insert1(int data){
        Node newNode = new Node(data);
        newNode.next = head1;
        head1 = newNode;
    }

    static void print(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println();
    }

    static void print1(){
        Node current = head1;
        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println();
    }

    static void printRes(){
        Node current = res;
        while(current != null){
            System.out.print(current.data + " ->");
            current = current.next;
        }
        System.out.println();
    }

    static Node reverse(){
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    static void print(Node head){
        System.out.println();
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println();
    }


    static void addLinkedLists(){
        Node p = head;
        Node q = head1;
        int carry = 0;
        while(p != null && q != null){
            int sum = p.data + q.data + carry;
            carry = sum /10;
            int rem = sum % 10;
            Node newNode = new Node(rem);
            newNode.next = res;
            res = newNode;
            p = p.next;
            q = q.next;
        }

        if(carry > 0 ){
            Node newNode = new Node(carry);
            newNode.next = res;
            res = newNode;
        }
    }

    public static Node  reverseList()
    {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next =prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args){
        insert(5);
        insert(0);
        insert(1);

        print();
        print(reverse());

    }
}
