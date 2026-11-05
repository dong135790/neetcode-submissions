class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] alph = new int[26];
            char[] word = str.toCharArray();
            for (char letter: word) {
                alph[letter - 'a']++;
            }
            
            map.putIfAbsent(Arrays.toString(alph), new ArrayList<>());
            map.get(Arrays.toString(alph)).add(str);
        }
        System.out.println(map.size());
        return new ArrayList<>(map.values());
    }
}
