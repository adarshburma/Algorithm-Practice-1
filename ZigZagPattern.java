package com.iheartmedia.salesforce.config.handler;

public class ZigZagPattern {
    public String convert(String s, int numRows) {
        if(numRows == 1){
           return s;
        }
        int row = 0;
        String[] arr = new String[numRows];
        boolean down = true;
        for(int i = 0 ; i< s.length(); i++){
            if(arr[row] == null){
                arr[row] = Character.toString(s.charAt(i));
            }else{
                arr[row] = arr[row] + Character.toString(s.charAt(i));
            }
            
            if(row == numRows-1){
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
        String str = "";
        for(String sarr: arr){
            if(sarr != null){
               str = str + sarr; 
            } 
        }
        return str;
    }

    public static void main(String args[]){
        ZigZagPattern zigZagPattern = new ZigZagPattern();
        zigZagPattern.convert("GEEKFORGEEKS", 3);
    }
}
