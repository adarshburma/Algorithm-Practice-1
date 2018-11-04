package org.practice.courses.courseapi;

import java.util.HashMap;

public class BooleanEvaluation {

    static int countEval(String str, boolean result){
        if(str == null){
            return 0;
        }

        if(str.length() == 1){
            return stringBool(str) == result ? 1 : 0;
        }

        int ways = 0;

        for(int i = 1; i< str.length(); i+=2){
            char c = str.charAt(i);
            String left = str.substring(0,i);
            String right = str.substring(i+1, str.length());

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if(c == '^'){
                totalTrue = leftTrue * rightFalse + rightTrue * leftFalse;
            } else if(c == '|'){
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            } else if(c == '&'){
                totalTrue = leftTrue * rightTrue;
            }
            int subways = result ? totalTrue : total - totalTrue;
            ways += subways;
        }
        return ways;
    }

    static int countEvalMemoized(String str, boolean result, HashMap<String, Integer> memo){
        if(str == null){
            return 0;
        }

        if(str.length() == 1){
            return stringBool(str) == result ? 1 : 0;
        }

        if(memo.containsKey(result+str)) return memo.get(result+str);

        int ways = 0;

        for(int i = 1; i< str.length(); i+=2){
            char c = str.charAt(i);
            String left = str.substring(0,i);
            String right = str.substring(i+1, str.length());

            int leftTrue = countEvalMemoized(left, true, memo);
            int leftFalse = countEvalMemoized(left, false, memo);
            int rightTrue = countEvalMemoized(right, true, memo);
            int rightFalse = countEvalMemoized(right, false, memo);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if(c == '^'){
                totalTrue = leftTrue * rightFalse + rightTrue * leftFalse;
            } else if(c == '|'){
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            } else if(c == '&'){
                totalTrue = leftTrue * rightTrue;
            }
            int subways = result ? totalTrue : total - totalTrue;
            ways += subways;
        }
        memo.put(result+str, ways);
        return ways;
    }

    static boolean stringBool(String str){
        return str.equals("1") ? true : false;
    }

    public static void main(String[] args){
        System.out.println(countEvalMemoized("1^0|0|1", false, new HashMap<String, Integer>()));
        System.out.println(countEvalMemoized("0&0&0&1^1|0", true, new HashMap<String, Integer>()));
    }
}
