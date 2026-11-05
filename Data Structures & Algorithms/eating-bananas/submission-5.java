class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for (int banana: piles) {
            if (banana > max) {
                max = banana;
            }
        }
        int k = max;

        while (min <= max) {
            int mid = min + (max - min)/2;
            long hours = 0;
            for (int banana: piles) {
                hours += (banana + mid - 1L) / mid;
            }
            if (hours > h) {
                min = mid + 1;
            } else {
                if (mid < k) {
                    k = mid;
                }
                max = mid - 1;
            }
        }
        return k;
    }
}
