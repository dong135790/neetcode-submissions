class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        int max = 0;
        for (int num: nums) {
            unique.add(num);
        }
        for (int num: unique) {
            if (!unique.contains(num - 1)) {
                int current = 1;
                while (unique.contains(num + current)) {
                    current++;
                }
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }
}
