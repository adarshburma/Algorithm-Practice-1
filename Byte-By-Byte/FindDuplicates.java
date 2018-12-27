package org.practice.courses.courseapi.practice12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {

    static List<Integer> findDuplicates(int[] arr){
        Set<Integer> res = new HashSet<Integer>();
        for(int i = 0 ; i < arr.length; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0){
                res.add(Math.abs(arr[index]));
            } else {
                arr[index] = -arr[index];
            }
        }

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = Math.abs(arr[i]);
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args){
        int[] arr = new int[] {2,1,2,1,2};
        System.out.print(findDuplicates(arr));
    }
}
