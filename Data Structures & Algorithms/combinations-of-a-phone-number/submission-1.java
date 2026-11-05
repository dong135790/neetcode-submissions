class Solution {

    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits.length() == 0) return output;
        backtrack(digits, 0, "", output);
        return output;
    }

    public void backtrack(String digits, int start, String current, List<String> output) {
        if (current.length() == digits.length()) {
            output.add(current);
        }

        for (int i = start; i < digits.length(); i++) {
            String combo = digitToChar[digits.charAt(i) - '0'];
            for (int j = 0; j < combo.length(); j++) {
                backtrack(digits, i + 1, current + combo.charAt(j), output);
            }
        }
    }
}
