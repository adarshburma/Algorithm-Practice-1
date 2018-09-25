package org.practice.courses.courseapi;

import java.util.Arrays;

public class StringPermutationOfAnother {
    static String sort(String str){
        char[] str_c = str.toCharArray();
        Arrays.sort(str_c);
        return new String(str_c);
    }
    static boolean solution(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        return sort(str1).equals(sort(str2));
    }

    /* is using length of each character in string*/
    static boolean solution2(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        int[] letters = new int[128];

        for(int i = 0 ; i < str1.length(); i++){
            letters[str1.charAt(i)]++;
        }

        for(int j = 0 ; j < str2.length(); j++){
            letters[str2.charAt(j)]--;
            if(letters[str2.charAt(j)] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(solution2("abc", "cab"));
    }
}
