/*

https://www.algoexpert.io/questions/Max%20Subset%20Sum%20No%20Adjacent

*/

class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
		
		if(array.length == 0){
			return 0;
		}
		
		if(array.length == 1){
			return array[0];
		}
		
		int first = array[0];
		int second = Math.max(first, array[1]);
		
		for(int i = 2 ; i < array.length; i++){
			int current = Math.max(second, first + array[i]);
			first = second;
			second = current;
		}
		
		return second;
  }
}
