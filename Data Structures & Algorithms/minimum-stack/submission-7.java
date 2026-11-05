class MinStack {

    Deque<Integer> stack;
    Deque<Integer> min;
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min.isEmpty()) {
            min.push(val);
        } else {
            if (val <= min.peek()) {
                min.push(val);
            }
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.pop();
        if (removed == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        }
        return -1;
    }
}
