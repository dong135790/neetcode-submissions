class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            } else {
                return num;
            }
        }
        return 0;
    }
}
