package org.practice.courses.courseapi;

import java.util.ArrayList;

public class Subsets {

    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list, int index){
        ArrayList<ArrayList<Integer>> allsubsets;
        if(index == list.size()){
            allsubsets = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> subset =  new ArrayList<>();
            allsubsets.add(subset);
        } else {
            allsubsets = getSubsets(list, index+1);
            int item = list.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for(ArrayList<Integer> sublist : allsubsets){
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(sublist);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }

            allsubsets.addAll(moreSubsets);
        }

        return allsubsets;
    }

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        for(ArrayList<Integer> sublists : getSubsets(list, 0)) {
            System.out.print(" " + sublists);
        }
    }
}
