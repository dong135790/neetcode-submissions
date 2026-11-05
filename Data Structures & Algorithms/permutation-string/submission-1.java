class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char letter: s1.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        int left = 0, right = 0;
        int need = map.size();
        while (right < s2.length()) {
            HashMap<Character, Integer> copy = new HashMap<>();
            int current = 0;
            left = right;
            while (left < s2.length()) {
                char letter = s2.charAt(left);
                copy.put(letter, copy.getOrDefault(letter, 0) + 1);

                if (map.getOrDefault(letter, 0) < copy.get(letter)) {
                    break;
                }

                if (map.getOrDefault(letter, 0) == copy.get(letter)) {
                    current++;
                }
                if (current == need) {
                    return true;
                }
                left++;
            }
            right++;
        }

        return false;
    }
}
