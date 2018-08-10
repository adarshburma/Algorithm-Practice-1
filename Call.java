package com.ihm.automation.utils.uputils.fulfillment;

public class Call {



    public static void main(String[] args){


//        LinkedList list = new LinkedList();
//        list.insert(1);
//        list.insert(5);
//        list.insert(2);
//        list.insert(4);
//        list.insert(3);
//
//        list.printList();
//        System.out.println();
//
//        System.out.println();
//
//        list.printListFrom(list.reverse(list.head));


        MaxHeapify max = new MaxHeapify();
        int[] arr = {1, 4, 2, 3, 9, 7, 8, 10, 14, 16};
        max.sort(arr);
        max.printArray(arr);
    }

}
