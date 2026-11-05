class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int distance = right - left;
            int area = height * distance;
            max = Math.max(area, max);
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
