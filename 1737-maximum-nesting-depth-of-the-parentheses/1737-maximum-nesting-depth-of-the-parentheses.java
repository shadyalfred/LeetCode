class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
            }

            if (c == ')') {
                depth--;
            }

            max = Math.max(max, depth);
        }

        return max;
    }
}