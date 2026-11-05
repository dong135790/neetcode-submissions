class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxFreq = 0;
        int max = 0;
        int limit = k;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            int windowSize = right - left + 1;
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));

            while (windowSize - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
                windowSize = right - left + 1;
            }
            max = Math.max(max, windowSize);
        }
        return max;
    }
}
