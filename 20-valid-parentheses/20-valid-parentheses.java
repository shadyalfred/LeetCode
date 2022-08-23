class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();       
        
        Set openings = Stream.of(
            '(', '[', '{'
        ).collect(Collectors.toCollection(HashSet::new));
        
        for (char c : s.toCharArray()) {
            if (openings.contains(c)) {
                stack.push(c);
            } else {
                if (stack.empty())
                    return false;
                
                switch (stack.peek()) {
                    case '[':
                        if (c != ']')
                            return false;
                        else
                            stack.pop();
                    break;
                        
                    case '(':
                        if (c != ')')
                            return false;
                        else
                            stack.pop();
                    break;
                        
                    case '{':
                        if (c != '}')
                            return false;
                        else
                            stack.pop();
                    break;
                        
                    default:
                        continue;
                }
            }
        }
        
        return stack.empty();
    }
}