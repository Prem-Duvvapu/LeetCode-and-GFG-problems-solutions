class MinStack {
    Stack<Long> stack;
    long minVal;

    public MinStack() {
        stack=new Stack<>();
        minVal=Long.MIN_VALUE;
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long)val);
            minVal=(long)val;
            return;
        }

        if ((long)val > (long)minVal) {
            stack.push((long)val);
        } else {
            stack.push(2*(long)val-minVal);
            minVal=(long)val;
        }
    }
    
    public void pop() {
        if (stack.isEmpty())
            return;

        if (stack.peek()>minVal) {
            stack.pop();
        } else {
            minVal=2*minVal-stack.pop();
        }
    }
    
    public int top() {
        if (stack.peek()>minVal) {
            long top=stack.peek();
            return (int)top;
        } else {
            return (int)minVal;
        }
    }
    
    public int getMin() {
        return (int)minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */