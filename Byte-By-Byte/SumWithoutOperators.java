package org.practice.courses.courseapi.practice12;

public class SumWithoutOperators {
    static int sum(int a ,int b){
        if(b == 0) return a;
        int partialSum = a ^ b;
        int carryOver = (a & b) << 1;
        return sum(partialSum, carryOver);
    }

    public static void main(String[] args){
        System.out.print(sum(9, 10));
    }
}
