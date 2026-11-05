class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int largest = 0;
        for (int i = 0; i <= heights.length; i++) {
                while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() -1;
                    largest = Math.max(largest, height * width);
                }
                stack.push(i);
        }
        return largest;
    }
}
