class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            int length = right - left;
            if (length <= k) {
                if (set.contains(nums[right])) {
                    return true;
                } else {
                    set.add(nums[right]);
                    right++;
                }
            } else {
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}