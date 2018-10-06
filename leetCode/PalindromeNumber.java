class PalindromeNumber{
  public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int temp= x;
        double rev = 0;
        while(temp > 0){
            double rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp/10;
        }
        
        if(rev > Integer.MAX_VALUE){
            return false;
        }
        
        if(rev < Integer.MIN_VALUE){
            return false;
        }
        
         if((int)rev == x){
            return true;
        }
        
        return false;
    }
}
