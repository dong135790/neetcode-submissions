class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int number: map.keySet()) {
            int frequency = map.get(number);
            bucket[frequency].add(number);
        }

        int index = 0;
        for (int i = bucket.length - 1; i > 0 && index < k; i--) {
            for (int num: bucket[i]) {
                result[index] = num;
                index++;
                if (index == k) return result;
            }
        }
        return result;
    }
}
