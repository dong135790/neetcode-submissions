class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int longest = 0;

        while (right < s.length()) {
            int window = right - left + 1;
            freq[s.charAt(right) - 'A']++;
            int current = 0;
            for (int count: freq) {
                current = Math.max(count, current);
            }
            if (window - current <= k) {
                longest = Math.max(window, longest);
            } else {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return longest;
    }
}

// class Solution {
//     public int characterReplacement(String s, int k) {
//         int longest = 0;
//         for (int i = 0; i < s.length(); i++) {
//             HashMap<Character, Integer> map = new HashMap<>();
//             for (int j = i; j < s.length(); j++) {
//                 int windowSize = j - i + 1;
//                 map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
//                 int maxFreq = 0;
//                 for (int count: map.values()) {
//                     maxFreq = Math.max(maxFreq, count);
//                 }
//                 if (windowSize - maxFreq <= k) {
//                     longest = Math.max(longest, windowSize);
//                 }
//             }
//         }
//         return longest;
//     }
// }
