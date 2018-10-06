class ParanthesisMatching{
  public boolean isValid(String s) {
        //Empty String return true
        if(s.isEmpty()){
            return true;
        }
        
        //If string length is not even return false.
        if(s.length() % 2 != 0){
            return false;
        }
        
        //create a stack
        Stack<Character> st = new Stack<>();
        
        //To track if atleast some input is pushed to stack
        boolean inputPushed = false;
        
        for(int i=0; i< s.length(); i++){
            char c= s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
                inputPushed = true;
            }
            if(!st.isEmpty()){
                if((c == ')' && st.peek() == '(') || (c == ']' && st.peek() == '[') 
                    || (c == '}' && st.peek() == '{')){
                st.pop();
                }
            }
            
        }
        
        if(st.isEmpty() && inputPushed){
            return true;
        }
        
        return false;
    }
}
