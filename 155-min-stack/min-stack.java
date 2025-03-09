//Space: O(2*n)
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    //O(1)
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
            return;
        }

        stack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }
    
    //O(1)
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    //O(1)
    public int top() {
        return stack.peek();
    }
    
    //O(1)
    public int getMin() {
        return minStack.peek();
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