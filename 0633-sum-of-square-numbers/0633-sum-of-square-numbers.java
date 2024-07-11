class Solution {
    public boolean judgeSquareSum(int c) {
        int sqrtC = (int) Math.sqrt(c);

        Set<Integer> squaredNums = new HashSet<>(sqrtC);

        for (int a = 0; a <= sqrtC; a++) {
            squaredNums.add(a * a);
        }

        for (int b = 0; b <= sqrtC; b++) {
            if (squaredNums.contains(c - b * b)) {
                return true;
            }
        }
        
        return false;
    }
}