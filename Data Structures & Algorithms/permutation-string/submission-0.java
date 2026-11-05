class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char letter: s1.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        int left = 0, right = 0;

        while (right < s2.length()) {
            if (map.containsKey(s2.charAt(right))) {
                left = right;
                int end = left + s1.length();
                HashMap<Character, Integer> copy = new HashMap<>(map);
                while (left < end && left < s2.length()) {
                    if (copy.containsKey(s2.charAt(left))) {
                        copy.put(s2.charAt(left), copy.get(s2.charAt(left)) - 1);
                    }
                    left++;
                }
                int sum = 0;
                for (int value : copy.values()) {
                    if (value != 0) {
                        sum += 2000;
                    }
                    sum += value;
                }
                if (sum == 0) return true;
            }
            right++;
        }
        return false;
    }
}
