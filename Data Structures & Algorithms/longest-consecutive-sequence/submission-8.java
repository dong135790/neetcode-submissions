class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        int max = 0;

        for (int num: nums) {
            if (unique.contains(num)) continue;
            unique.add(num);
        }

        for (int num: unique) {
            if (!unique.contains(num - 1)) {
                int start = num;
                int current = 1;
                while (unique.contains(num + current)) {
                    current += 1;
                }
                if (current > max) max = current;
            }
        }
        return max;
    }
}
