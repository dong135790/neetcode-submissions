class Solution {
public void sortColors(int[] nums) {
    int left = 0;
    while (left < nums.length) {
        int minIdx = left;
        for (int i = left; i < nums.length; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }
        int temp = nums[left];
        nums[left] = nums[minIdx];
        nums[minIdx] = temp;
        left++;
    }
}
}