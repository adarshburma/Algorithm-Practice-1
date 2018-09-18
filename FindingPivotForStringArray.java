public class FindingPivotForStringArray {

    public static int findRotationPoint(String[] words) {

       int floorindex = 0;
       int ceilindex = words.length -1;
       
       if(words[ceilindex].compareTo(words[floorindex]) >= 0){
           return 0;
       }
       
       while(floorindex < ceilindex){
           int mid = floorindex + (ceilindex - floorindex)/2;
           if(words[mid].compareTo(words[floorindex]) >= 0){
               floorindex = mid;
           }else{
               ceilindex = mid;
           }
           
           if(floorindex +1 == ceilindex){
               break;
           }
       }
       
       return ceilindex;
    }
