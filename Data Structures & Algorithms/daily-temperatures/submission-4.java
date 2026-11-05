class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()) {
                stack.pop();
                int index = indexStack.pop();
                result[index] = (i - index);
            }
            stack.push(temperatures[i]);
            indexStack.push(i);
        }
        return result;
    }
}
