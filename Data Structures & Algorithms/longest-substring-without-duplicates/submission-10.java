class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> set = new HashMap<>();
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            if (set.containsKey(s.charAt(right))) {
                left = Math.max(set.get(s.charAt(right)) + 1, left);
            }
            
            set.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
