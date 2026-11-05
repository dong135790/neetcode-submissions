class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (char letter: t.toCharArray()) {
            tmap.put(letter, tmap.getOrDefault(letter, 0) + 1);
        }

        HashMap<Character, Integer> copy = new HashMap<>(tmap);

        int shortest = Integer.MAX_VALUE;
        int[] coord = new int[2];

        int left = 0, right = 0;
        int matched = t.length();
        
        while (right < s.length()) {
            if (copy.containsKey(s.charAt(right))) {
                if (copy.get(s.charAt(right)) > 0) {
                    matched--;
                }
                copy.put(s.charAt(right), copy.get(s.charAt(right)) - 1);
            }
            while (matched == 0) {
                int window = right - left + 1;
                if (window < shortest) {
                    shortest = window;
                    coord[0] = left;
                    coord[1] = right;
                }
                if (left < s.length() && tmap.containsKey(s.charAt(left))) {
                    copy.put(s.charAt(left), copy.getOrDefault(s.charAt(left), 0) + 1);
                    if (copy.get(s.charAt(left)) > 0) {
                        matched++;
                    }
                }
                left++;
            }
            right++;
        }
        System.out.println( coord[0]);
        if (shortest == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(coord[0], coord[1] + 1);
        }
    }
}
