class ReverseInteger{
  public int reverse(int x) {
        boolean negetive = false;
        
        if(x < 0){
            x = -x;
            negetive = true;
        }
        double rev = 0;
        while(x > 0){
            double rem = x % 10;
            rev = rev * 10 + rem;
            x = x/10;  
        }
        
        if(negetive){
            rev = -rev;
        }
        
        if(rev > Integer.MAX_VALUE){
            return 0;
        }
        
        if(rev < Integer.MIN_VALUE){
            return 0;
        }
        
        return (int)rev;
    }
}
