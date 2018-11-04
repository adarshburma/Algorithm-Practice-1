package org.practice.courses.courseapi;

import java.util.ArrayList;

/*
 * Permutations without repetitions/ Duplicates
 * 
 *
 * */

public class PermutationWithoutDups {
    /*
    * Extract first character and insert it all all possible places
    * P(a1,a2) -> P(a1,a2,a3)
    * */
    static ArrayList<String> permutations(String str){
        if(str == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<>();
        if(str.length() == 0){
            permutations.add("");
            return permutations;
        }

        char c = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = permutations(remainder);
        for(String word: words){
            for(int i = 0 ; i <= word.length(); i++){
                String sub = insertCharAt(word, c, i);
                permutations.add(sub);
            }
        }

        return permutations;
    }

    static String insertCharAt(String str, char c , int j){
        String before = str.substring(0, j);
        String after = str.substring(j);
        return before + c + after;

    }

    /**
     * Prepend chacter to permutations
     */

    static ArrayList<String> permutationsPrepend(String str){
        if(str == null){
            return null;
        }

        ArrayList<String> permutations = new ArrayList<>();
        if(str.length() == 0){
            permutations.add("");
            return permutations;
        }

        for(int i = 0 ; i < str.length(); i++){
            String before = str.substring(0,i);
            String after = str.substring(i+1);
            ArrayList<String> words = permutationsPrepend(before+after);
            for(String word : words){
                permutations.add(str.charAt(i) + word);
            }
        }

        return permutations;
    }

    public static void main(String[] args){
        System.out.println(permutations("ROAD"));
        System.out.println(permutationsPrepend("ROAD"));
   }

}
