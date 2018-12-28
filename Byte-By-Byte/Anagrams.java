package org.practice.courses.courseapi.practice12;

public class Anagrams {

    static boolean isAnagram(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int[] characters = new int[1<<8];

        for(int i = 0 ; i < str1.length(); i++){
            characters[str1.charAt(i)]++;
        }

        for(int i = 0 ; i < str2.length(); i++){
            characters[str2.charAt(i)]--;
        }

        for(int i : characters){
            if(i > 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.print("Is Anagram " + isAnagram("Abcas", "aabcD"));
    }
}
