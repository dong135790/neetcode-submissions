class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        backtrack(n, 0, 0, "", output);
        return output;
    }

    public void backtrack(int n, int open, int close, String current, List<String> output) {
        if (open == n && close == n) {
            output.add(current);
            return;
        }

        if (open < n) {
            backtrack(n, open + 1, close, current + "(", output);
        }
        if (close < open) {
            backtrack(n, open, close + 1, current + ")", output);
        }
    }

}
