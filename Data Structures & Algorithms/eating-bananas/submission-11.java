class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile: piles) {
            high = Math.max(pile, high);
        }
        int rate = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // System.out.println("Low: " + low + " high: " + high + " mid: " + mid);
            double time = 0;
            for (int pile: piles) {
                time += Math.ceil((double)pile/mid);
            }
            // System.out.println("Time: " + time);
            if (time > h) {
                // We take longer than required time. Gotta eat more
                low = mid + 1;
            } else {
                // We eating at a fast pace. Eat less
                high = mid - 1;
                rate = Math.min(rate, mid);
            }
        }
        return rate;
        // return low;
    }
}
