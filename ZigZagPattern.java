package com.iheartmedia.salesforce.config.handler;

public class ZigZagPattern {

    public void zigzagPattern(String str, int numRows){
        if(numRows == 1){
            System.out.println(str);
            return;
        }
        String[] arr = new String[numRows];
        boolean down = true;
        int row = 0;
        for(int i = 0; i<str.length(); i++){
            if(arr[row] == null){
                arr[row] = str.charAt(i)+ " ";
            }else{
                arr[row] =arr[row] +  str.charAt(i)+ " ";
            }

            if(row == numRows -1){
                down = false;
            }

            if(row == 0){
                down = true;
            }

            if(down){
                row++;
            }else{
                row--;
            }
        }
        for(String s : arr){
            System.out.println(s);
        }
    }

    public static void main(String args[]){
        ZigZagPattern zigZagPattern = new ZigZagPattern();
        zigZagPattern.zigzagPattern("GEEKFORGEEKS", 3);
    }
}
