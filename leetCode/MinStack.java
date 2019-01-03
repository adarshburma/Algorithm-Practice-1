/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/


class Element {
    Element next;
    int val;
    int min;
    Element(int val, int min){
        this.val = val;
        this.min= min;
    }
}

class MinStack {
    Element top;
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        if(top == null){
            top = new Element(x,x);
        } else {
            Element ele = new Element(x, Math.min(x, top.min));
            ele.next = top;
            top = ele;
        }
    }
    
    public void pop() {
        if(top == null){
            return;
        }
        Element temp = top.next;
        top.next = null;
        top = temp;
    }
    
    public int top() {
        if(top == null){
            return 0;
        }
        return top.val;
    }
    
    public int getMin() {
        if(top == null){
            return 0;
        }
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
