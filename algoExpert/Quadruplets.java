import java.util.ArrayList;
import java.util.HashMap;

class Program {
  public static ArrayList<Integer[]> fourNumberSum(int[] array, int targetSum) {
    // Write your code here.
		HashMap<Integer, ArrayList<Integer[]>> allpairs = new HashMap<>();
		ArrayList<Integer[]> quadruplets = new ArrayList<>();
		
		for(int i = 0 ; i < array.length; i++){
			for(int j = i+1; j < array.length; j++){
					int currentSum = array[i] + array[j];
					int complement = targetSum - currentSum;
					
					if(allpairs.containsKey(complement)){
						for(Integer[] arr: allpairs.get(complement)){
							quadruplets.add(new Integer[]{arr[0], arr[1], array[i], array[j]});
						}	
					}		
			}
															
			for(int k = 0; k < i; k++){
				int currentSum = array[i] + array[k];
				if(!allpairs.containsKey(currentSum)){
					ArrayList<Integer[]> list = new ArrayList<>();
					list.add(new Integer[]{array[i], array[k]});
					allpairs.put(currentSum, list);
				} else {
					Integer[] newArray = new Integer[]{array[i], array[k]};
					ArrayList<Integer[]> list = allpairs.get(currentSum);
					list.add(newArray);
					allpairs.put(currentSum, list);
				}	
			}
		}
		return quadruplets;
  }
}
