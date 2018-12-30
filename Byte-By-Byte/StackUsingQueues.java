package org.practice.courses.courseapi.practice12;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

  static private Queue<Integer> primary = new LinkedList<>();
  static private Queue<Integer> secondary = new LinkedList<>();

  static void push(int i){
      secondary.add(i);
      while(!primary.isEmpty()){
          secondary.add(primary.remove());
      }

      Queue<Integer> temp = primary;
      primary = secondary;
      secondary = temp;
  }

  static int pop(){
      return primary.remove();
  }

    public static void main(String[] args){
        push(1);
        push(3);
        push(5);
        push(7);

       System.out.println(pop()) ;
       System.out.println(pop()) ;
       System.out.println(pop()) ;


    }

}
