class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int largest = 0;
        int min = 10000;
        for (int i = 0; i <= heights.length; i++) {
            if (i == heights.length) {
                while (!stack.isEmpty()) {
                    int middle = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek() -1;
                    largest = Math.max(largest, heights[middle] * width);
                }
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() -1;
                    largest = Math.max(largest, height * width);
                }
                stack.push(i);
            }
        }
        return largest;
    }
}
