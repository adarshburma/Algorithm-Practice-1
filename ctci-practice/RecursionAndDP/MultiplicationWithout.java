package org.practice.courses.courseapi;

/*
* Multiplication without using * / functions using recursion.
*
*
* */
public class MultiplicationWithout {

    static int multiplication(int a, int b){
        int smaller = a < b ? a : b;
        int bigger = a < b ? b : a;

        if(smaller == 0){
            return 0;
        }

        if(smaller == 1) {
             return bigger;
        }

        int s = smaller >> 1; // smaller divided by 2

        int side1 = multiplication(s, bigger);
        int side2 = side1;

        if(smaller % 2 == 1){
            side2 = multiplication(smaller-s , bigger);
        }

        return side1 + side2;

    }

    static int multiplicationHelper(int a , int b){
        int smaller = a < b ?  a : b;
        int bigger = a < b ? b : a;

        int[] memo = new int[smaller + 1];
        return multiplicationWorker(smaller, bigger, memo);

    }

    static int multiplicationWorker(int smaller, int bigger, int[] memo){

        if(smaller == 0){
            return 0;
        }

        if(smaller == 1){
            return bigger;
        }

        if(memo[smaller] > 0){
            return memo[smaller];
        }

        int s = smaller >> 1;
        int side1 = multiplicationWorker(s, bigger, memo);
        int side2 = side1;

        if(smaller % 2 == 1){
            side2 = multiplicationWorker(smaller-s, bigger, memo);
        }

        memo[smaller]= side1 + side2;
        return memo[smaller];

    }

    static int multiplicationBetterSolution(int a, int b){

        /*
        if smaller is even for example (30, 35) , ans is double of (15,35) but if smaller is odd (31, 35) we
        can do double of (15,35) + bigger
        */

        int bigger =  a < b ? b : a;
        int smaller = a < b ? a : b;
        if(smaller == 0){
            return 0;
        }

        if(smaller == 1){
            return bigger;
        }

        int s = smaller >> 1;
        int evenSide = multiplicationBetterSolution(s, bigger);
        if(smaller % 2 == 0){
            return evenSide + evenSide;
        } else {
            return evenSide + evenSide + bigger;
        }
    }

    public static void main(String[] args){
        System.out.print(multiplicationBetterSolution(2,3));
    }

}
