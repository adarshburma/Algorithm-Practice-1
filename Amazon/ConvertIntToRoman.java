package com.iheartmedia.salesforce.controller.sorting;

import java.util.HashMap;

public class ConvertToRoman {

    static HashMap<Integer, String> map = new HashMap<>();

    static void fillHashMap(HashMap<Integer, String> map){
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XD");
        map.put(50,"D");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(900,"CM");
        map.put(1000,"M");
        map.put(5000,"MMMMM");
        map.put(9000,"MMMMMMMMM");
    }

    static String getRomanByPlace(int place, int reminder){

            StringBuilder sb = new StringBuilder();
            if(reminder == 9){
                sb.append(map.get(9 * place));
                reminder = reminder - 9;
            } else if(reminder >= 5){
                sb.append(map.get(5 * place));
                reminder = reminder - 5;
            } else if(reminder == 4){
                sb.append(map.get(4 * place));
                reminder = reminder -4;
            }

            while(reminder > 0){
                sb.append(map.get(place));
                reminder = reminder -1;

            }

            return sb.toString();
    }

    static String RomanConverter(int input){
        fillHashMap(map);
        StringBuilder output=  new StringBuilder();
        int place = 1;

        while(input > 0){
            int reminder = input % 10;
            if(reminder > 0){
                String previous = output.toString();
                output.setLength(0);
                output.append(getRomanByPlace(place, reminder) + previous);
            }
            place = place * 10;
            input = input /10;
        }

        return output.toString();
    }

    public static void main(String[] args){
        fillHashMap(map);
        System.out.print(convertIntToRoman(8023));
    }

    static String getRomanPlace(int reminder, int place){
        StringBuilder sb = new StringBuilder();
        if(reminder == 9){
            sb.append(map.get(9 * place));
            reminder = reminder - 9;
        } else if( reminder >= 5){
            sb.append(map.get(5 * place));
            reminder = reminder - 5;
        } else if( reminder == 4){
            sb.append(map.get(4 * place));
            reminder = reminder - 4;
        }

        while(reminder > 0){
            sb.append(map.get(place));
            reminder = reminder -1;
        }

        return sb.toString();
    }

    static String convertIntToRoman(int input){
        StringBuilder output = new StringBuilder();
        int place = 1;
        while(input > 0){
            int reminder = input % 10;
            if(reminder > 0){
                String previous = output.toString();
                output.setLength(0);
                output.append(getRomanPlace(reminder, place) + previous);
            }
            place = place * 10;
            input = input/10;
        }

        return output.toString();
    }
}
