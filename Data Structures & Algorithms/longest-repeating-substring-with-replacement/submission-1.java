class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            int current = 0;
            for (int j = i; j < s.length(); j++) {
                int windowSize = j - i + 1;
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                int maxFreq = 0;
                for (int count: map.values()) {
                    maxFreq = Math.max(maxFreq, count);
                }
                if (windowSize - maxFreq <= k) {
                    longest = Math.max(longest, windowSize);
                }

            }
            longest = Math.max(longest, current);
        }

        return longest;
    }
}
/*

X Y Y X
L
R

X Y Y X
L R

Current 3
X Y Y X
L   R

Current 4   k = 0
X Y Y X G H G 
  L     R

X -> 1
Y -> 2
G -> 1

4 - 2 = 2


*/