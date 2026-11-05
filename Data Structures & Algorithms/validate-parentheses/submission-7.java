class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char symbol: s.toCharArray()) {
            if (symbol == '[' || symbol == '{' || symbol == '(') {
                stack.push(symbol);
            } else if (!stack.isEmpty()) {
                char top = stack.peek();
                if (
                    top == '{' && symbol == '}' ||
                    top == '[' && symbol == ']' ||
                    top == '(' && symbol == ')'
                ) {
                    stack.poll();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// [