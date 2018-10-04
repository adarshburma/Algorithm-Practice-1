package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapNumbersToCharacters {

    static List<String> mapper(String digits){
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        ArrayList<String> result = new ArrayList<String>();

        if(digits.length() == 0 || digits == null){
            return result;
        }
        char[] arr = new char[digits.length()];
        //helper(result, arr, map, digits, 0);

        getString(map,digits, 0, arr, result);

        return result;
    }

    static void helper(ArrayList<String> result, char[] arr, HashMap<Character, char[]> map,
                        String digits, int index){
        if(index == digits.length()){
            result.add(new String(arr));
            return;
        }

        char c = digits.charAt(index);
        char[] candidates = map.get(c);
        for(int i = 0 ; i < candidates.length;i++){
            arr[index] = candidates[i];
            System.out.println(arr);
            helper(result, arr, map, digits, index+1);
        }
    }

    static void getString(HashMap<Character, char[]> map, String digits, int index, char[] arr, ArrayList<String> res){
        if(digits.length() == index){
            res.add(new String(arr));
            return;
        }

        char c = digits.charAt(index);
        char[] candidates = map.get(c);
        for(int i= 0; i < candidates.length; i++){
            arr[index] = candidates[i];
            getString(map,digits,index+1, arr,res);
        }
    }

    public static void main(String[] args){
        System.out.print(mapper("234"));
    }
}
