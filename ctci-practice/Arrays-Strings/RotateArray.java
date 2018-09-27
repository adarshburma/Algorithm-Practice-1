package org.practice.courses.courseapi;

public class RotateArray {
    public static void rotateByOne(int[] arr){
        int n = arr.length;
        int temp = arr[0];
        for(int i =0 ; i < n-1; i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = temp;
    }


    public static int gcd(int a, int b){
        if(a == b){
            return a;
        }

        return gcd(a, (a%b));
    }

    public static void rotateJuggling(int[] arr, int d, int n){
        for(int i = 0 ; i < gcd(d,n); i++){
            int temp = arr[i];
            int j = i;
            while(true){
                int k = j + d;
                if( k >= n){
                    k = k - n;
                }

                if(k == i){
                    break;
                }

                arr[j] = arr[k];
                j = k;
            }

            arr[j] = temp;
        }
    }

    public static void main(String args[]){
        int[] arr= new int[]{2,3,5,7};
//        for(int i= 0 ; i < 4 ; i++){
//            rotateByOne(arr);
//        }

        rotateJuggling(arr, 4, arr.length);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
