class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > right) {
                right = piles[i];
            }
        }
        int left = 1;
        int k = right;
        while (left <= right) {
            int mid = left + (right - left) /2;
            int totalTime = 0;
            for (int i = 0; i < piles.length; i++) {
                totalTime += Math.ceil((double)piles[i]/mid);
            }
            if (totalTime > h) {
                left = mid + 1;
            } else {
                k = mid;
                right = mid - 1;
            }
        }
        return k;
    }
}
/*
1, 4, 3, 2      Min: 1      Max: 4          Mid = 2
1 + 2+ 2 + 1 = 6 hours < 9 hours

                Min: 1      Max: 1



*/