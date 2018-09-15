package org.practice.courses.courseapi;


public class ProductLeavingIndex {

    public static int[] productLeavingIndex(int[] arr){
        if(arr.length < 2){
            new IllegalArgumentException("can's have less than 2 integers");
        }

        int[] productBeforeIndex = new int[arr.length];

        int productSoFar = 1;
        for(int i = 0 ; i< arr.length; i++){
            productBeforeIndex[i] = productSoFar;
            productSoFar = productSoFar * arr[i];
        }
        int[] productAfterIndex = new int[arr.length];

        productSoFar = 1;

        for(int i = arr.length-1; i >=0 ; i--){
            productAfterIndex[i] = productSoFar;
            productSoFar = productSoFar * arr[i];
        }

        int[] productLeavingIndex = new int[arr.length];

        for(int i = 0 ; i < arr.length; i++){
            productLeavingIndex[i] = productBeforeIndex[i] * productAfterIndex[i];
        }

        return productLeavingIndex;
    }

    public static void main(String args[]){
        int[] input = new int[] {2,4,10};
        int[] res = productLeavingIndex(input);
        for(int i : res){
            System.out.println(i);
        }
    }
}
