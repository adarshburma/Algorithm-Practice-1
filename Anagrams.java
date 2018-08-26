package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

    public void insertAtAllPositions(List<String> potentialAnagramList, char current, List<String> anagramList){
        for(String potentialAnagram : potentialAnagramList){
            for(int index = 0; index <= potentialAnagram.length(); index++){
                StringBuilder sb = new StringBuilder(potentialAnagram);
                if(index < potentialAnagram.length()){
                    sb.insert(index, current);
                }else{
                    sb.append(current);
                }

                System.out.println("String builder: " + sb.toString());
                anagramList.add(sb.toString());
            }
        }
    }

    public List<String> findAll(String word){
        if(word.length() == 1){
            List<String> potentialAnagram = new ArrayList<>();
            potentialAnagram.add(word);
            return potentialAnagram;
        }

        List<String> anagramList = new ArrayList<>();
        char current = word.charAt(0);
        String subset = word.substring(1, word.length());
        List<String> potentialAnagramList = findAll(subset);
        System.out.println("Potential Anagrams: "+ potentialAnagramList.toString());
        insertAtAllPositions(potentialAnagramList, current, anagramList);

        return anagramList;
    }

    public void printAll(List<String> anagramList){
        for(String anagram: anagramList){
            System.out.println(anagram);
        }
    }

    public static void main(String args[]){
        Anagram2 anagram2 = new Anagram2();
        anagram2.printAll(anagram2.findAll("road"));
    }
}
