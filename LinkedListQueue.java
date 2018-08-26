package org.practice.courses.courseapi;

public class LinkedListQueue {
    Node front, rear;
    static class Node{

        Node next;
        int data;

        Node(int data){
            this.data = data;
        }

    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null){
            rear = newNode;
            front = newNode;
        }

        rear.next = newNode;
        rear = rear.next;
    }

    public Node dequeue(){
        if(front == null){
            return null;
        }
        Node node = front;
        front = front.next;

        if(front == null){
            rear = null;
        }

        return node;
    }

    public void printQueue(){
        Node current = front;

        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String args[]){
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.printQueue();
        System.out.println("Remove all");
        System.out.println(queue.dequeue().data);
        System.out.println(queue.dequeue().data);
        System.out.println(queue.dequeue().data);
        System.out.println(queue.dequeue().data);
        System.out.println("print all:");
        queue.printQueue();
    }


}
