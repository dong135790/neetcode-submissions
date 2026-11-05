class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int min = 0;
        int max = nums.length - 1;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] < nums[max]) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return nums[min];
    }
}
/*
1 2 .3 4 5 6 <- left --
6 1 .2 3 4 5 <- left 
5 6 .1 2 3 4 <- center
4 5 .6 1 2 3 <- right --
3 4 .5 6 1 2 <- right -- 
       L C R
3 4 .5 6 1 2 
       L
       R
2 3 .4 5 6 1 <- right --
*/