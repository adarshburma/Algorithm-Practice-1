package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationWithDups {

    static ArrayList<String> permutationsWithDups(String str){
        if(str == null){
            return null;
        }

        HashMap<Character, Integer> map = buildCountMap(str);
        ArrayList<String> res = new ArrayList<>();
        permutationsWithDupsHelper("", str.length() , map, res);
        return res;
    }


    static HashMap<Character, Integer> buildCountMap(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ;i < str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        return map;
    }

    static void permutationsWithDupsHelper(String prefix, int rem, HashMap<Character,
            Integer> map, ArrayList<String> res) {
        if(rem == 0){
            res.add(prefix);
        }

        for(Character c : map.keySet()){
            int count  = map.get(c);
            if(count > 0){
                map.put(c, map.get(c)-1);
                permutationsWithDupsHelper(prefix+c, rem-1, map, res);
                map.put(c, count);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(permutationsWithDups("ROOAD"));
    }
}
