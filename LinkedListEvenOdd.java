package org.practice.courses.courseapi;

public class LinkedListEvenOdd {
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            head.next = null;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void print(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void print(Node head){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node oddThenEven(){
        if(head == null){
            return null;
        }
        Node result = head;
        Node odd = head;
        Node even = head.next;
        Node connectNode = head.next;

        while(odd != null && even != null){
            Node t = even.next;
            if(t == null){
                break;
            }

            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = connectNode;
        return result;
    }

    public Node evenOdd(){
        if(head == null){
            return null;
        }

        Node result = head;
        Node odd = head;
        Node even = head.next;
        Node connect = head.next;

        while(even != null && odd != null){
            Node t = even.next;
            if(t == null){
                break;
            }
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = connect;
        return result;
    }

    public static void main(String args[]){
        LinkedListEvenOdd linkedListEvenOdd = new LinkedListEvenOdd();
        linkedListEvenOdd.insert(1);
        linkedListEvenOdd.insert(2);
        linkedListEvenOdd.insert(3);
        linkedListEvenOdd.insert(4);
        linkedListEvenOdd.insert(5);
       // linkedListEvenOdd.print();
        linkedListEvenOdd.print(linkedListEvenOdd.evenOdd());
    }
}

