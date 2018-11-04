package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ParenthesisPermutations {
    static Set<String> parenthesisPermutations(int num){
        Set<String> res = new HashSet<>();
        if(num == 0 ){
            res.add("");
        } else{
            Set<String> partial = parenthesisPermutations(num-1);
            for(String str : partial){
                for(int i = 0 ; i < str.length(); i++){
                    if(str.charAt(i) == '(') {
                        String s = insertAt(str, i);
                        res.add(s);
                    }
                }
                res.add("()" + str);
            }
        }
        return res;
    }

    static String insertAt(String str, int i){
        String before = str.substring(0,i);
        String after = str.substring(i+1);
        return before+"()"+after;
    }

    public static void main(String[] args){
        System.out.println(parenthesisPerm(5));
        System.out.println(permuteParenthesis(5));
    }

    static Set<String> parenthesisPerm(int num){
        Set<String> set=  new HashSet<>();
        if(num == 0){
            set.add("");
        } else {
            Set<String> partials = parenthesisPerm(num-1);
            for(String str: partials){
                for(int i = 0 ; i < str.length(); i++){
                    if(str.charAt(i) == '('){
                        String s = insertAt(str, i);
                        set.add(s);
                    }
                }

                set.add("()"+str);
            }
        }

        return set;
    }

    static void permuteParenthesisHelper(ArrayList<String> res, int left, int right, char[] str, int index){
        if(left < 0 || right < 0){
            return;
        }

        if(left == 0 && right == 0){
            res.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            permuteParenthesisHelper(res, left -1, right, str, index+1);

            str[index] = ')';
            permuteParenthesisHelper(res, left, right-1, str, index+1);
        }
    }

    static ArrayList<String> permuteParenthesis(int num){
        char[] str = new char[num*2];
        ArrayList<String> res=  new ArrayList<>();
        permuteParenthesisHelper(res,num, num, str, 0);
        return res;
    }


}
