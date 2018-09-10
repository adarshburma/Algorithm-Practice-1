package com.iheartmedia.salesforce.config.handler;

public class AddTwoNumbers {
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void insertNode(int data){
        Node newNode = new Node(data);
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

    public void printFrom(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data +  " -> ");
            current = current.next;
        }
    }

    public Node addTwoNumbers(Node head1, Node head2){
        Node dummyhead = new Node(0);
        Node curr= dummyhead;
        Node p = head1;
        Node q = head2;
        int carry = 0;
        while(p != null || q != null){
            int x = (p == null)? 0 : p.data;
            int y = (q == null)? 0 : q.data;
            int sum = x + y + carry;
            carry = sum/10;
            curr.next = new Node(sum%10);
            curr = curr.next;

            if(p != null) p = p.next;
            if(q != null) q = q.next;

        }
        if(carry > 0){
            curr.next = new Node(carry);
        }
        return dummyhead.next;
    }

    public static void main(String args[]){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.insertNode(3);
        addTwoNumbers.insertNode(4);
        addTwoNumbers.insertNode(2);
        addTwoNumbers.printFrom(addTwoNumbers.head);

        System.out.println();

        AddTwoNumbers addTwoNumbers2 = new AddTwoNumbers();
        addTwoNumbers2.insertNode(4);
        addTwoNumbers2.insertNode(6);
        addTwoNumbers2.insertNode(5);
        addTwoNumbers2.printFrom(addTwoNumbers2.head);

        System.out.println();
        AddTwoNumbers addTwoNumbers1 = new AddTwoNumbers();
        addTwoNumbers1.printFrom(addTwoNumbers1.addTwoNumbers(addTwoNumbers.head, addTwoNumbers2.head));

    }

}
