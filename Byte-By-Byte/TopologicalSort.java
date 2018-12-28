package org.practice.courses.courseapi.practice12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TopologicalSort {

    static List<Integer> ordering(int[][] processes){
        HashSet<Integer> tempMark = new HashSet<>();
        HashSet<Integer> permMark = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        for(int i = 0 ; i < processes.length; i++){
            if(!permMark.contains(i)){
                visit(i, processes, tempMark, permMark, results);
            }
        }

        return results;
    }
    
    static void visit(int process,
                      int[][] processes,
                      HashSet<Integer> tempMark,
                      HashSet<Integer> permMark,
                      List<Integer> results) {
        if(tempMark.contains(process)) throw new IllegalArgumentException();
        if(!permMark.contains(process)){
            tempMark.add(process);
            for(int i : processes[process]){
                visit(i, processes, tempMark, permMark, results);
            }

            permMark.add(process);
            tempMark.remove(process);
            results.add(process);
        }
    }

    public static void main(String[] args){
        int[][] processes = new int[][]{{}, {0}, {0}, {1,2}, {3}};

        System.out.print(ordering(processes));
    }
}
