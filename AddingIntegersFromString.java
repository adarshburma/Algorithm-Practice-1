public class AddingIntegersFromString {
    
    public int addNums(String str){
        int num = 0, res = 0;
        boolean negetive = false;
        for(int i=0; i< str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                if(str.charAt(i-1) == '-'){
                    num = num * 10 + (str.charAt(i) - '0'); 
                    negetive = true;
                }else{
                    num = num * 10 + (str.charAt(i) - '0');
                }
                
            }else{
               
                if(negetive){
                    num = -num;
                }
                 System.out.println(num);
                res = res + num;
                num = 0;
                negetive = false;
            }
        }
        
        return res;
    }
    public static void main(String args[]) {
        String str = "-100klh564-20abc365bg";
        MyClass my = new MyClass();

        System.out.println("Res = " + my.addNums(str));
    }
}
