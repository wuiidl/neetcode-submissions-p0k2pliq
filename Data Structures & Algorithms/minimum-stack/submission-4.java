class MinStack {

    private final Stack<Integer> min = new Stack<>();
    private final Stack<Integer> stack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;

        int top = stack.pop();
        if(top == min.peek()) {
            min.pop();
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
