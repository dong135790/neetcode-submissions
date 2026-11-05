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
            int hours = 0;
            for (int banana: piles) {
                hours += Math.ceil((double)banana/mid);
            }
            if (hours > h) {
                min = mid + 1;
            } else {
                k = mid;
                max = mid - 1;
            }
        }
        return k;
    }
}
