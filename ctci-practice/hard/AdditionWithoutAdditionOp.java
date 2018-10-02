package org.practice.courses.courseapi;

public class AdditionWithoutAdditionOp {
    static int add(int a, int b){
        if(b == 0){
            return a;
        }

        int sum = a ^ b;
        int carry = (a & b) << 1;

        return add(sum,carry);
    }

    static int add2(int a, int b){
        while(b != 0){
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }

    public static void main(String[] args){
        System.out.println("Sum" + add(2,3));
        System.out.print("Sum" + add2(2,3));
    }
}
