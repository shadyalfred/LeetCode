class Solution {
    public int maxDepth(String s) {
        int max = 0;

        List<Character> stack = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                stack.removeLast();
            }

            if (c == '(') {
                stack.add('(');
            }

            max = Math.max(max, stack.size());
        }

        return max;
    }
}