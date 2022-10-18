class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        int high = rows * columns;
        int low = 0;
        
        while (low < high) {
            int mid = (high + low) / 2;
            
            int row = mid / columns;
            int column = mid % columns;
            
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return false;
    }
}