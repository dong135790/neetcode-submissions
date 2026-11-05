class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> word1 = new HashMap<>();
        HashMap<Character, Integer> word2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            word1.put(s.charAt(i), word1.getOrDefault(s.charAt(i), 0) + 1);
            word1.put(t.charAt(i), word1.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int n: word1.values()) {
            if (n != 0) return false;
        }
        return true;
    }
}
