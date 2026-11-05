class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String value : tokens) {
            if (value.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (value.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);                
            } else if (value.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (value.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(value));
            }
        }
        return stack.pop();
    }
}
