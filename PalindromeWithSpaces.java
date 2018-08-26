public class PalindromeWithSpaces {
     public String reverse(String str){
        
        if(str == null || str.length() <= 1){
            return str;
        }
        if(str.charAt(0) == ' '){
            return reverse(str.substring(1));
        }else{
             return reverse(str.substring(1)) + str.charAt(0);
        }
       
    }
    
    public String removeSpaces(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        if(str.charAt(0) == ' '){
            return removeSpaces(str.substring(1));
        }else{
             return str.charAt(0) + removeSpaces(str.substring(1)) ;
        }
    }
    
    public boolean isPallindrone(String str){
         String reverse = reverse(str.toLowerCase());
         System.out.println(reverse + " " + removeSpaces(str.toLowerCase()));
        if(removeSpaces(str.toLowerCase()).equals(reverse)){
            return true;
        }
        
        return false;
    }
    
   public static void main(String args[])
    {
        MyClass t = new MyClass();
       
        System.out.println(t.isPallindrone("I am Mai"));
    }
}
