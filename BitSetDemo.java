package com.iheartmedia.salesforce.config.handler;
import java.util.BitSet;

public class BitSetDemo {

    public void getMissingNumbers(int[] numbers, int count){
        int missingCount = count - numbers.length;
        int lastMissingIndex = 0;
        BitSet bitSet = new BitSet(count);
        for (int number: numbers){
            bitSet.set(number-1);
        }

        System.out.println("Missing numbers: ");
        for (int i=0 ; i < missingCount; i++){
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }


   public static void main(String args[]){
        BitSetDemo bitSetDemo = new BitSetDemo();
        bitSetDemo.getMissingNumbers(new int[] {1,4,9,10,13, 15,17,20, 22, 25, 30}, 30);
   }
}
