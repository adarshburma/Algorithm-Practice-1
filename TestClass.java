import java.util.*;


class TestClass implements Comparator<String> {
    
    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }
    
    
    public static List<Character> stringToCharacterSet(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        return list;
    }

    public static boolean containsAllChars(String container, String containee) {
        return stringToCharacterSet(container).containsAll
                   (stringToCharacterSet(containee));
    }
    
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
        */
       
        String[] arr;
        
        TestClass ss = new TestClass();
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        
        for (int i = 0; i < N; i++) {
           
            int num_strings = Integer.parseInt(s.nextLine());
            
            arr = new String[num_strings];
            //Read input of strings
            for (int k = 0 ; k < num_strings ; k++ ){
                arr[k] = s.nextLine();
                
            }
    
            StringBuilder sb = new StringBuilder(s.nextLine());
            StringBuilder str = new StringBuilder();
            List<String> word_list = new ArrayList<String>();
            
            //(str.length() + arr[l].length())
         for (int l = 0 ; l < arr.length ; l++){
               if (containsAllChars(sb.toString(), arr[l])) {
                   word_list.add(arr[l]);
               }   
            } 
            
         Collections.sort(word_list, ss);
         
         for (String word : word_list ){
             if((str.length() + word.length()) <= sb.length()){
                         str.append(word);   
                   } 
         }
                
       
          if(str.length() == sb.length()){
                System.out.println("YES");
          } else{
                System.out.println("NO");
          }   
         
        }
        
    }
}
