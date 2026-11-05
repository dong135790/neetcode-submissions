class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char letter: s.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        for (char letter: t.toCharArray()) {
            if (map.containsKey(letter) && map.get(letter) > 0) {
                map.put(letter, map.get(letter) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
