/*

Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"


*/



package org.practice.courses.courseapi.practice12;

import java.util.HashMap;

public class MinimumSubstringUnique {

   static String uniqueSubstring(String str, char[] arr){
        HashMap<Character, Integer> counts = new HashMap<>();

        // initialize char array with all chars from char array
        for(char c : arr){
            counts.put(c, 0);
        }

        // uniqueChars in the window
        int uniqueChars = 0;

        // min length
        int minlen = Integer.MAX_VALUE;

        // min string
        String minString = "";

        //start and end points of the window.
        int s = 0, e = 0;

        while(e < str.length()){

            System.out.println("num of unique characters " + uniqueChars);
            System.out.println("minLength " + minlen);
            System.out.println("minString " + minString);
            System.out.println("start " + s);
            System.out.println("end " + e);

            if(e == str.length()-1 && s == e){
                break;
            }

            // expansion char
            char ec = str.charAt(e);

            // expand window ...
            if(!counts.containsKey(ec)){
                e++;
                continue;
            } else {
                if(counts.get(ec) == 0){
                    uniqueChars++;
                }
                counts.put(ec, counts.get(ec)+1);
            }

            // valid window contains all chars from the arr ...
            if(uniqueChars == arr.length){
                int len = e - s + 1;
                if(minlen > len){
                    minlen = len;
                    minString = str.substring(s, e+1);
                }

                // shrink window so long as unique chars == arr.length ...
                while (uniqueChars == arr.length){
                    System.out.println("start inside shrink ... : " + s);
                    System.out.println("end inside shrink ... : " + e);
                    System.out.println("unique chars : " + uniqueChars);

                    //update min string and min length ...
                    int length = e - s + 1;
                    if(minlen > length){
                        minlen = length;
                        minString = str.substring(s, e+1);
                    }

                    //shrink character
                    char sc = str.charAt(s);
                    if(counts.containsKey(sc)){
                        if(counts.get(sc)-1 == 0){
                            uniqueChars--;
                        }
                        counts.put(sc, counts.get(sc)-1);
                        s++;

                    } else {
                        s++;
                        continue;
                    }
                }
            }

            e++;
        }

        return minString;
    }

    public static void main(String[] args){
       char[] arr = {'x', 'y', 'z'};
        System.out.print("minimum substring " + uniqueSubstring("xyyzyzyx", arr));
    }
}
