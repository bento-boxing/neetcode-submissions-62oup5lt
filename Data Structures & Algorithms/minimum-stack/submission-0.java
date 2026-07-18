class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minimumStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minimumStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        minimumStack.push(Math.min(val, minimumStack.size() == 0 ? val : minimumStack.peek()));
    }
    
    public void pop() {
        stack.pop();
        minimumStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimumStack.peek();
    }
}
