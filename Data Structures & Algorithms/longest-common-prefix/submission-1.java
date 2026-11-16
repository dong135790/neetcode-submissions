class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String word = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int first = 0;
            while (first < word.length() && first < strs[i].length() && strs[i].charAt(first) == word.charAt(first)) {
                first++;
            }
            word = word.substring(0, first);
        }
        return word;
    }
}