class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0));
        }
        return false;
    }
}