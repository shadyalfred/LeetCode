class Solution {
    public int minOperations(String[] logs) {
        int level = 0;

        for (String log : logs) {
            switch (log) {
                case "../":
                    if (level <= 0) {
                        continue;
                    } else {
                        level--;
                    }
                    break;
                case "./":
                    continue;
                default:
                    level++;
            }
        }
        
        return level;
    }
}