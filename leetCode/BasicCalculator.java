package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculator {

    static int calculator(String str){
        str = str.replaceAll(" ", "");
        Stack<String> stack = new Stack<>();
        char[] arr = str.toCharArray();


        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < arr.length; i++){
            if(arr[i] == ' '){
                continue;
            }

            if(arr[i] >= '0' || arr[i] <= '9'){
                sb.append(arr[i]);

                if(i == arr.length-1){
                    stack.push(sb.toString());
                }
            } else {
                if(sb.length() > 0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }

                if(arr[i] != ')'){
                    stack.push(new String(new char[] {arr[i]}));
                } else {
                    ArrayList<String> t= new ArrayList<>();
                    while(!stack.isEmpty()){
                        String ele = stack.pop();
                        if(ele == "("){
                            continue;
                        } else {
                            t.add(0,ele);
                        }
                    }

                    int temp = 0;
                    if(t.size() == 1){
                        temp = Integer.valueOf(t.get(0));
                    } else {
                        for(int j = t.size()-1 ; j > 0; j = j - 2 ){
                            if(t.get(j-1).equals("-")){
                                temp += 0 - Integer.valueOf(t.get(j));
                            } else {
                                temp += Integer.valueOf(t.get(j));
                            }
                        }

                        temp += Integer.valueOf(t.get(0));
                    }
                    stack.push(String.valueOf(temp));
                    System.out.println("temp " + temp);
                }

            }
        }

        ArrayList<String> t = new ArrayList<String>();
        while (!stack.isEmpty()) {
            String elem = stack.pop();
            t.add(0, elem);
        }

        int temp = 0;
        for (int i = t.size() - 1; i > 0; i = i - 2) {
            if (t.get(i - 1).equals("-")) {
                temp += 0 - Integer.valueOf(t.get(i));
            } else {
                temp += Integer.valueOf(t.get(i));
            }
        }
        System.out.print("temp " + t);
        temp += Integer.valueOf(t.get(0));

        return temp;
    }

    public static int calculate(String s) {
        // delte white spaces
        s = s.replaceAll(" ", "");

        Stack<String> stack = new Stack<String>();
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ')
                continue;

            if (arr[i] >= '0' && arr[i] <= '9') {
                sb.append(arr[i]);

                if (i == arr.length - 1) {
                    stack.push(sb.toString());
                }
            } else {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }

                if (arr[i] != ')') {
                    stack.push(new String(new char[] { arr[i] }));
                } else {
                    // when meet ')', pop and calculate
                    ArrayList<String> t = new ArrayList<String>();
                    while (!stack.isEmpty()) {
                        String top = stack.pop();
                        if (top.equals("(")) {
                            break;
                        } else {
                            t.add(0, top);
                        }
                    }

                    System.out.println("t: " + t);

                    int temp = 0;
                    if (t.size() == 1) {
                        temp = Integer.valueOf(t.get(0));
                    } else {
                        for (int j = t.size() - 1; j > 0; j = j - 2) {
                            if (t.get(j - 1).equals("-")) {
                                temp += 0 - Integer.valueOf(t.get(j));
                            } else {
                                temp += Integer.valueOf(t.get(j));
                            }
                        }
                        temp += Integer.valueOf(t.get(0));
                    }
                    stack.push(String.valueOf(temp));
                }
            }
        }

        ArrayList<String> t = new ArrayList<String>();
        while (!stack.isEmpty()) {
            String elem = stack.pop();
            t.add(0, elem);
        }

        int temp = 0;
        for (int i = t.size() - 1; i > 0; i = i - 2) {
            if (t.get(i - 1).equals("-")) {
                temp += 0 - Integer.valueOf(t.get(i));
            } else {
                temp += Integer.valueOf(t.get(i));
            }
        }
        temp += Integer.valueOf(t.get(0));

        return temp;

    }

    static int calculator2(String str){
        str = str.replaceAll(" ", "");
        Stack<String> stack = new Stack<>();
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == ' '){
                continue;
            }

            if(arr[i] >= '0' && arr[i] <= '9'){
                sb.append(arr[i]);

                if(sb.length() == arr.length-1){
                    stack.push(sb.toString());
                }
            } else {
                if(sb.length() > 0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                if( arr[i] != ')'){
                    stack.push(new String(new char[] {arr[i]}));
                } else { //when you encounter ')'
                    ArrayList<String> t = new ArrayList<>();
                    while(!stack.isEmpty()) {
                        String top = stack.pop();
                        if(top.equals("(")){
                            break;
                        } else {
                            t.add(0, top);
                        }
                    }

                    int temp = 0;
                    if(t.size() == 1){
                        temp = Integer.valueOf(t.get(0));
                    } else {
                        for(int j = t.size()-1; j > 0 ; j = j -2){
                            if(t.get(j-1) == "-"){
                                temp += 0 - Integer.valueOf(t.get(j));
                            }else {
                                temp += Integer.valueOf(t.get(j));
                            }
                        }
                        temp += Integer.valueOf(t.get(0));
                    }
                    stack.push(String.valueOf(temp));
                }

            }
        }

        ArrayList<String> t = new ArrayList<>();
        while(!stack.isEmpty()){
            String top = stack.pop();
            t.add(0,top);
        }
        int temp = 0;
        for(int j = t.size()-1; j > 0; j = j-2){
            if(t.get(j-1).equals("-")){
                temp += 0 - Integer.valueOf(t.get(j));
            } else {
                temp += Integer.valueOf(t.get(j));
            }
        }

        temp += Integer.valueOf(t.get(0));

        return temp;
    }

    public static void main(String[] args){
       // System.out.println("result: " + calculator("(1+(4+5+2)-3)+(6+8)"));
        System.out.print("result: " + calculator2("(1+(4+5+2)-3)+(6+8)"));

        //System.out.println("res: " + calculate("(1+(4+5+2)-3)+(6+8)"));

//        while(!res.isEmpty()){
//            System.out.println(res.pop());
//        }

    }
}
