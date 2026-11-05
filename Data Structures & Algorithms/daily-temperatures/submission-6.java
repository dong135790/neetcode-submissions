class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>(); 
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] popped = stack.pop();
                result[popped[1]] = i - popped[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}
// {30, 2} 

// [1,  4,  1,  2,  1,  0,  0 ]
// [30, 38, 30, 36, 35, 40, 28]