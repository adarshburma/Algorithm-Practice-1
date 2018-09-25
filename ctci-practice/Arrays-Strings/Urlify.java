package org.practice.courses.courseapi;

public class Urlify {

    static String Solution(char[] str, int truelength){
        int index, i , spacecount = 0;

        for(int j = 0 ; j < truelength; j++){
            if(str[j] == ' '){
                spacecount++;
            }
        }

        index = truelength + spacecount * 2;
        System.out.println("index" + index);
        if(truelength < str.length) str[truelength] = '\0';
        for(i = truelength-1; i >= 0 ; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            }else{
                str[index -1] = str[i];
                index--;
            }
        }

        return new String(str);
    }


    static String practice(char[] str, int truelength){
        int index,i,spacecount= 0;
        for(int j = 0 ; j < truelength; j++){
            if(str[j] == ' '){
                spacecount++;
            }
        }

        index = truelength + spacecount * 2;
        if(truelength < str.length) {
            str[truelength] = '\0';
        }

        for(i = truelength-1; i >= 0 ; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            }else{
                str[index - 1] = str[i];
                index--;
            }
        }

        return new String(str);
    }

    public static void main(String[] args){
        String str = "Mr John Smith    ";
        String res = practice(str.toCharArray(), 13);
        System.out.println(res);
    }
}
