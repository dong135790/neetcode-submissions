class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()])  {
                // Found a potential valley. Now i need to find the right max.

                int mid = stack.pop();
                if (stack.isEmpty()) break;

                int left = stack.peek();
                int width = i - left - 1;
                int boundedHeight = Math.min(height[left], height[i]) - height[mid];
                int waterSeg = width * boundedHeight;
                water += waterSeg;
            }
            stack.push(i);
        }
        return water;
    }
}
// 3
// LH = 3
// W = 3