class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char letter: s.toCharArray()) {
            if (letter == '[' || letter == '{' || letter == '(') {
                stack.push(letter);
            } else {
                if (!stack.isEmpty()) {
                    char peek = stack.peek();
                    if (letter == ']' && peek == '[' || letter == '}' && peek == '{' || letter == ')' && peek == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
