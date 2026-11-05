class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char symbol: s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (
                    top == '{' && symbol == '}' ||
                    top == '[' && symbol == ']' ||
                    top == '(' && symbol == ')'
                ) {
                    stack.poll();
                    continue;
                }
            }
            stack.push(symbol);
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
