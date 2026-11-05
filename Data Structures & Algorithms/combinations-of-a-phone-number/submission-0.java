class Solution {


    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> cell = new HashMap<>();
        cell.put('2', "abc");
        cell.put('3', "def");
        cell.put('4', "ghi");
        cell.put('5', "jkl");
        cell.put('6', "mno");
        cell.put('7', "pqrs");
        cell.put('8', "tuv");
        cell.put('9', "wxyz");
        List<String> output = new ArrayList<>();
        if (digits.length() == 0) return output;
        backtrack(digits, 0, "", output, cell);
        return output;
    }

    public void backtrack(String digits, int start, String current, List<String> output, HashMap<Character, String> cell) {
        if (current.length() == digits.length()) {
            output.add(current);
        }

        for (int i = start; i < digits.length(); i++) {
            String combo = cell.get(digits.charAt(i));
            for (int j = 0; j < combo.length(); j++) {
                backtrack(digits, i + 1, current + combo.charAt(j), output, cell);
            }
        }
    }
}
