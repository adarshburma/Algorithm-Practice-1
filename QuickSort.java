public class QuickSort {
    
    public void quicksort(int[] arr, int start, int end){
        if(start < end){
            
            int pI = partition(arr,start,end);
            
            quicksort(arr,start,pI-1);
            quicksort(arr,pI+1,end);
            
        }
       
    }
    
    public int partition(int[] arr, int start, int end){
        int partition = arr[end];
        int pIndex = start-1;
        int temp = 0;
        
        for(int i = start; i<end; i++){
            if(arr[i] <= partition){
                pIndex++;
                temp = arr[pIndex];
                arr[pIndex] = arr[i];
                arr[i] = temp;
                
            }
        }
        
       int temp2 = 0;
       temp2 = arr[pIndex+1];
       arr[pIndex+1] = arr[end];
       arr[end] = temp2;
       
       return pIndex+1;
    }
    
    public static void main(String args[]) {
      MyClass my= new MyClass();  
      int arr[] = {8,4,3,1,9,6,5};
      my.quicksort(arr,0,arr.length-1);
  
      for(int i=0; i<arr.length; i++){
          if(i != arr.length-1){
              System.out.print(arr[i] + ", ");
          }else{
              System.out.print(arr[i]);
          }
          
      } 
    }
}
