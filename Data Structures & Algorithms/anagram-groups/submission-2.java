class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            int[] position = new int[26];
            for (char letter: s.toCharArray()) {
                position[letter - 'a']++;
            }
            String cord = Arrays.toString(position);
            // String cord = position.toString();
            map.putIfAbsent(cord, new ArrayList<>());
            map.get(cord).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
