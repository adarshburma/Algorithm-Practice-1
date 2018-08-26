public class MergeSort {
    
    public void merge(int[] arr, int s, int m, int e){
        int n1= m-s+1;
        int n2 = e-m;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
       
        
        for(int i=0; i<n1;i++){
            L[i] = arr[s+i];
        }
        
        for(int j=0; j<n2; j++){
            R[j] = arr[m+1+j];
        }
        int i=0,j=0,k=s;
        
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            
            k++;
        }
        
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        
         while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
     void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        MyClass my = new MyClass();
        my.sort(arr,0,arr.length-1);
    
        
        for(int i=0; i<arr.length; i++){
            if(i < arr.length-1){
                System.out.print(arr[i]+ ", ");
            }else{
                System.out.print(arr[i]);
            }
            
        }

    }
}
