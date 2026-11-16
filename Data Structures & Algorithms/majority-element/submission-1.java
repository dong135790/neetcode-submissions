class Solution {
    public int majorityElement(int[] nums) {
        System.out.println(nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxV = 0;
        int output = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= nums.length / 2 + 1) {
                return entry.getKey();
            }
        }
        return output;
    }
}