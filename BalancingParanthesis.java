public class BalancingParanthesis {
    
    static class stack{
        int top = -1;
        char[] stack = new char[100];
        public stack(){}
        public void push(char c){
            if(top == 99){
                System.out.println("stack is full");
                return;
            }
              
              stack[++top] = c;  
        }
        
        public boolean isEmpty(){
            if(top == -1){
                return true;
            }
            
            return false;
        }
        
        public char pop(){
            
            if(top == -1){
                System.out.println("Stack is empty");
            }
            
            char c = stack[top];
            top--;
            return c;
        }
        
        public void print(){
            for(int i = top; i >= 0; i--){
                System.out.println(stack[i]);
            }
        }
        
        
    }   
    
        public boolean isMatchingpair(char c, char c1){
            if((c == '(' && c1 == ')') || (c == '{' && c1 == '}') || (c == '[' && c1 == ']')){
                return true;
            }
            
            return false;
        }
        
        public boolean isParenthesisBalanced(String str){
            stack s = new stack();
            char[] str_c = str.toCharArray();
            for(int i=0; i<str_c.length; i++){
                if(str_c[i] == '(' || str_c[i] == '[' || str_c[i] == '{'){
                   s.push(str_c[i]);     
                }
                
                if(str_c[i] == ')' || str_c[i] == ']' || str_c[i] == '}'){
                    if(s.isEmpty()){
                        return false;
                    }else if( !isMatchingpair(s.pop() , str_c[i])){
                        return false;
                    }
                }
                
            }
        
            if(s.isEmpty()){
                return true;
            }else{
                return false;
            }
        }
    
    public static void main(String args[]) {
        String str = "{()}[]";
        
        MyClass my = new MyClass();
        System.out.println(my.isParenthesisBalanced(str));
        

    }
}
