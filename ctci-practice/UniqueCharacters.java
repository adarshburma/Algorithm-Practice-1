package org.practice.courses.courseapi;

import java.util.HashMap;

public class UniqueCharacters {

    /*
    * this solution aims at ASCII 128 (confined to a-z and A-Z) , depending on problem we can goto 256 ASCII
    * String can also have unicode characters 160
    * */

    static boolean mysolution(String str){
        char[] str_c = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < str_c.length; i++){
            if(!map.containsKey(str_c[i])){
                map.put(str_c[i], 1);
            }
            else{
                return false;
            }
        }

        return true;
    }

    /*
    this solution is confined to a- z checker is a bit Vector being used to store
    all the characters already visited.
    */
    static boolean solutionASCII (String str){
        if(str.length() > 128){
            return false;
        }

        boolean[] chars = new boolean[128];
        for(int i = 0 ; i < str.length(); i++){
            int val = str.charAt(i);
            if(chars[val]){
                return false;
            }
            chars[val] = true;
        }

        return true;
    }

    static boolean solutionChecker(String str){
        int checker = 0 ;
        for(int i = 0 ; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            System.out.println("val" + val);
            System.out.println("1 << val" + (1 << val));
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);

            System.out.println("checker: "+ checker);
        }
        return true;
    }   

    public static void main(String[] args){

            System.out.println(solutionASCII("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLM123456789{}[];'<>"));
            System.out.println(solutionChecker("abcdefgha"));
    }
}
