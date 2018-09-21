package com.iheartmedia.salesforce.config.handler;

public class Sorting {
    static int[] input = new int[] {2,1,5,3,4};
    public static void swap(int[] arr, int i, int j){
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }

    public static void selectionSort(int[] arr){
        for(int i=0; i< arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr){
        for(int i=0; i< arr.length; i++){
            boolean swap = false;
            for(int j = arr.length-1; j > i; j--){
                if(arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                    swap = true;
                }
            }

            if(!swap){
                break;
            }
        }
    }

    public static void insertionSort(int[] arr){
        for(int i = 0 ; i < arr.length-1; i++){
            for(int j = i+1; j > 0 ; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j-1, j);
                }else{
                    break;
                }
            }
        }
    }

    public static void insertionSortForShellSort(int[] arr, int startIndex, int increment){
        for(int i= startIndex; i < arr.length; i = i + increment){
            for(int j = Math.min(arr.length-1, i+increment); j - increment >= 0 ; j = j-increment){
                if(arr[j-increment] > arr[j]){
                    swap(arr, j, j-increment);
                }else{
                    break;
                }
            }
        }
    }

    public static void shellSort(int[] arr){
        int increment = arr.length/2;
        while (increment >= 1){
            for(int startIndex = 0; startIndex < increment; startIndex++){
                insertionSort2(arr, startIndex, increment);
            }
            increment = increment/2;
        }
    }

    public static void insertionSort2(int[] arr, int startIndex, int increment){
        for(int i = startIndex; i< arr.length; i= i + increment){
            for(int j = Math.min(arr.length-1, i + increment); j - increment >= 0; j = j- increment){
                if(arr[j-increment] > arr[j]){
                    swap(arr, j - increment, j);
                }else{
                    break;
                }
            }
        }
    }

    public static void shellSort2(int[] arr){
        int increment = arr.length /2;
        while(increment >= 1){
            for(int startIndex = 0 ; startIndex <= increment; startIndex++){
                insertionSort2(arr, startIndex, increment);
            }
            increment = increment/2;
        }
    }

    public static void insertionSort3(int[] arr, int startIndex, int increment){
        for(int i = startIndex; i< arr.length; i = i + increment){
            for(int j = Math.min(arr.length-1, i + increment); j - increment >= 0; j = j - increment){
                if(arr[j - increment] > arr[j]){
                    swap(arr,j-increment, j);
                } else{
                    break;
                }
            }
        }
    }

    public static void shellSort3(int[] arr){
        int increment = arr.length/2;
        while(increment >= 1){
            for(int startIndex = 0 ; startIndex < increment; startIndex++){
                insertionSort3(arr, startIndex, increment);
            }
            increment = increment/2;
        }
    }

    public static int partition(int[] arr, int low, int high){
      int pIndex = low-1;
      int pivot = arr[high];
      int temp = 0;
      for(int i = low; i< high; i++){
          if(arr[i] <= pivot){
              pIndex++;
              temp = arr[pIndex];
              arr[pIndex] = arr[i];
              arr[i] = temp;
          }
      }
      int temp2 = arr[pIndex+1];
      arr[pIndex+1] = arr[high];
      arr[high] = temp2;

      return pIndex+1;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(high > low){
            int pivot = partition2(arr,low, high);
            quickSort(arr, low,pivot-1);
            quickSort(arr,pivot+1, high);
        }
    }


    public static void split(int[] arr, int[] firstHalf, int[] secondHalf){
        int firstHalfIndex = 0;
        int secondHalfStartIndex = firstHalf.length;
        for(int i = 0 ; i < arr.length; i++){
            if(i < firstHalf.length){
                firstHalf[i] = arr[i];
            }else {
                secondHalf[i-secondHalfStartIndex] = arr[i];
            }
        }
    }

    public static void merge(int[] listSort, int[] firstHalf, int[] secondHalf){
        int index = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        while(firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length){
            if(firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]){
                listSort[index] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            }else if(secondHalfIndex < secondHalf.length){
                listSort[index] = secondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            index++;
        }

        if(firstHalfIndex < firstHalf.length){
            while(index < listSort.length){
                listSort[index] = firstHalf[firstHalfIndex];
                index++; firstHalfIndex++;
            }
        }

        if(secondHalfIndex < secondHalf.length){
            while(index < listSort.length){
                listSort[index] = secondHalf[secondHalfIndex];
                index++; secondHalfIndex++;
            }
        }
    }

    public static void mergeSort(int[] arr){
        if(arr.length == 1){
            return;
        }

        int mid = (arr.length / 2) + (arr.length % 2);
        int[] firstHalf = new int[mid];
        int[] secondHalf = new int[arr.length - mid];
        split(arr, firstHalf, secondHalf);

        mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(arr, firstHalf, secondHalf);

    }

    public static void print(){
        for(int i : input){
            System.out.print(i + " ");
        }
    }

    public static void print(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }

    public static int partition2(int[] arr, int low, int high){
        int pIndex = low-1;
        int pivot = arr[high];
        int temp = 0 ;

        for(int i =low; i < high; i++){
            if(arr[i] < pivot){
                pIndex++;
                temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;
            }
        }

        int temp2 = arr[pIndex+1];
        arr[pIndex+1] = arr[high];
        arr[high] = temp2;

        return pIndex+1;
    }

    public static void main(String args[]){
        int[] test = new int[] {6,2,1,7,3,8};
        quickSort(test, 0, test.length-1);
        print(test);
        //selectionSort(input);
//        shellSort3(input);
//        print();
    }
}
