class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // NO IDEA HOW I DID THIS. I USED AI FOR THIS. REVIEW LATER
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length, m = nums2.length;
        int total = n + m;
        int half = (total+ 1) / 2;

        int left = 0;
        int right = n;

        while (left <= right) {
            int i = left + (right - left)/ 2;
            int j = half - i;

            // Step 3: Handle edge cases with Infinity
            int left1 = (i > 0) ? nums1[i-1] : Integer.MIN_VALUE;
            int right1 = (i < n) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j-1] : Integer.MIN_VALUE;
            int right2 = (j < m) ? nums2[j] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                // Even total
                if (total % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                }
                return (double) Math.max(left1, left2);
            } else if (left1 > right2) {
                right = i - 1;
            } else {
                left = i + 1;
            }

        }
        return -1;
    }
}
