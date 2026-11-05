
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int len = map.size();
        for (int number: map.values()) {
            if (number != 1) {
                return true;
            }
        }
        return false;
    }
}