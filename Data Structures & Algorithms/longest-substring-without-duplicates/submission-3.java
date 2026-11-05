class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
            } else {
                // If the set contains that character, remove everthing until we get to it.
                // How do we keep track? List? LinkedList
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            maxLength = Math.max(set.size(), maxLength);
            right++;
        }
        return maxLength;
    }
}

// xyzyz