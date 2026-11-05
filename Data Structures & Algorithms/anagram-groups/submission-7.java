class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word: strs) {
            int[] frequency = new int[26];
            for (char letter: word.toCharArray()) {
                frequency[letter - 'a']++;
            }
            String freq = Arrays.toString(frequency);
            if (!map.containsKey(freq)) map.put(freq, new ArrayList<>());
            map.get(freq).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
