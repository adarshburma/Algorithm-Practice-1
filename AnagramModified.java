package com.iheartmedia.salesforce.config.handler;

import java.util.ArrayList;
import java.util.List;

public class AnagramMofied {
    static List<String> res = new ArrayList<>();
    public static List<String> findAllInterleavings(String str1, String str2, String interleaving){
      if(str1 == null){
          res.add(str2);
      }

      if(str2 == null){
          res.add(str1);
      }

      if(str1.length() == 0 && str2.length() == 0){
          res.add(interleaving);
      }

      if(str1.length() > 0){
          findAllInterleavings(str1.substring(1), str2, interleaving+str1.charAt(0));
      }

      if(str2.length() > 0){
          findAllInterleavings(str1, str2.substring(1), interleaving+str2.charAt(0));
      }

      return res;
  }

    public static void main(String args[]){
       findAllInterleavings("AB" ,"CD", "");
       System.out.print(res);
    }
}
