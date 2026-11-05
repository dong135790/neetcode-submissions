class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int water = 0;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                water += Math.min(leftMax, rightMax) - height[left];
            }

            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                water += Math.min(leftMax, rightMax) - height[right];
            }

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return water;
    }
}
// 2