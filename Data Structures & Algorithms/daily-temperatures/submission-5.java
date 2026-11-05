class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        // Deque<Integer> indexStack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] popped = stack.pop();
                // int index = indexStack.pop();
                result[popped[1]] = (i - popped[1]);
            }
            stack.push(new int[]{temperatures[i], i});
            // indexStack.push(i);
        }
        return result;
    }
}
