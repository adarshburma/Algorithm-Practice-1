 public class FindMinimumInRotatedArray {

    public int findMinimumn(int[] arr){
        int left = 0;
        int right = arr.length-1;

        if(arr[right] > arr[left]){
            return arr[left];
        }

        while(left < right){
            int mid = left+right/2;

            if(arr[mid] > arr[mid+1]){
                return arr[mid+1];
            }

            if(arr[mid-1] > arr[mid]){
                return arr[mid];
            }

            if(arr[mid] > arr[0]){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        FindMinimumInRotatedArray findMinimumRotated = new FindMinimumInRotatedArray();
        int[] arr = new int[]{8,9,10,1,2,3,4,5,6,7};
        int[] arr2 = new int[]{1,2,3,4,5,6};
        System.out.println(findMinimumRotated.findMinimumn(arr2));

    }
}
