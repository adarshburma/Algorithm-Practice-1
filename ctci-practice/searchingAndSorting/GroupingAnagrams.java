package org.practice.courses.courseapi;
import java.util.*;

public class GroupingAnagrams {
    //Using Comparator
    static class CompareAnagrams implements Comparator<String> {
        public String sort(String s){
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String s1, String s2) {
            return sort(s1).compareTo(sort(s2));
        }

    }

    static String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    //Using HashMap
    static String[] groupAnagrams(String[] input){
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();
        for (String i: input){
            String key = sort(i);
            if(anagrams.containsKey(key)){
                ArrayList<String> list = anagrams.get(key);
                list.add(i);
                anagrams.put(key, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(i);
                anagrams.put(key, list);
            }
        }

        int index = 0;
        for(String s: anagrams.keySet()){
            ArrayList<String> list = anagrams.get(s);
            for(String ele : list){
                input[index] = ele;
                index++;
            }
        }

        return input;
    }

    public static void main(String[] args){
        String[] input = {"cat", "dog", "tac", "god", "act"};
        Arrays.sort(input, new CompareAnagrams());

        for(String s: input){
            System.out.print(s + " ");
        }

        System.out.println();
       // HashMap<String, ArrayList<String>> map = groupAnagrams(input);
        for(String s: groupAnagrams(input)){
            System.out.print(" "+ s);
        }

    }
}
