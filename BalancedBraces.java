/*
input:  text = “(()”
output: 1

input:  text = “(())”
output: 0

input:  text = “())(”
output: 2

*/

static int bracketMatch2(String text) {
    int openbrace = 0;
    int closingbrace = 0;
    for(int i = 0 ; i < text.length(); i++){
      if(text.charAt(i) == '('){
        openbrace++;
      } else if(openbrace > 0 && text.charAt(i) == ')'){
        openbrace--;
      } else {
        closingbrace++;
      }
    }
    
    return openbrace + closingbrace;
  }
  
  static int bracketMatch(String text) {
    // your code goes here
    Stack<Character> stack = new Stack<Character>();
    int closingbraces = 0;
    for(int i = 0 ; i < text.length(); i++){
      if(text.charAt(i) == '('){
        stack.push('(');
      } else if(!stack.isEmpty() && text.charAt(i) == ')'){
        stack.pop();
      } else {
          closingbraces++;
      }
    }

    return stack.size() + closingbraces;
  }
