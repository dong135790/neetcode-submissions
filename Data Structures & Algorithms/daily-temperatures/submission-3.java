class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // Deque<Integer> stack = new ArrayDeque<>();

        // for (int i = 0; i < temperatures.length; i++) {
        //     stack.push(temperatures[i]);
            
        // }
        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            int j = i + 1;
            while (j < temperatures.length && temperatures[j] <= temperatures[i]) {
                count++;
                j++;
            }
            if (j < temperatures.length && temperatures[j] > temperatures[i]) {
                count++;
                result[i] = count;
            }
        }
        return result;
    }
}
