package org.practice.courses.courseapi;

public class HighestProductOf3 {
    public static int highestProductOf3(int[] arr){
        if(arr.length < 3){
            throw new IllegalArgumentException("Array size can't be less than 3");
        }

        int highestProductOf3 = arr[0] * arr[1] * arr[2];
        int highestProductOf2 = arr[0] * arr[1];
        int lowestProductOf2 = arr[0] * arr[1];
        int highest = Math.max(arr[0], arr[1]);
        int lowest = Math.min(arr[0], arr[1]);
        int current = 0;

        for(int i = 2 ; i < arr.length; i++){
            current = arr[i];
            highestProductOf3 = Math.max(Math.max(highestProductOf3, current * highestProductOf2), current * lowestProductOf2);
            highestProductOf2 = Math.max(Math.max(highestProductOf2, current * highest), current * lowest);
            lowestProductOf2 = Math.min(Math.min(lowestProductOf2, current * lowest), current * highest);
            highest = Math.max(highest, current);
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }

    public static int highestProductOf32(int[] arrayOfInts) {

        if (arrayOfInts.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }

        // we're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        // we could also start these as null and check below if they're set
        // but this is arguably cleaner
        int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
        int lowest  = Math.min(arrayOfInts[0], arrayOfInts[1]);

        int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
        int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

        // except this one--we pre-populate it for the first *3* items.
        // this means in our first pass it'll check against itself, which is fine.
        int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

        // walk through items, starting at index 2
        for (int i = 2; i < arrayOfInts.length; i++) {
            int current = arrayOfInts[i];

            // do we have a new highest product of 3?
            // it's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(
                    highestProductOf3,
                    current * highestProductOf2),
                    current * lowestProductOf2);

            // do we have a new highest product of two?
            highestProductOf2 = Math.max(Math.max(
                    highestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new lowest product of two?
            lowestProductOf2 = Math.min(Math.min(
                    lowestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }

    public static void main(String args[]){
        int[] input = new int[] {1, 10, -5, 1, -100};
        System.out.println(highestProductOf3(input));
    }

}
