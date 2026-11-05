class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), output);
        return output;
    }

    // start at a position and expand outwards
    public void backtrack(String s, int start, List<String> subset, List<List<String>> output) {
        if (start == s.length()) {
            output.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                subset.add(sub);
                backtrack(s, i + 1, subset, output);
                subset.remove(subset.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
