/*
Start from bottom left corner and if:
i) curr > target, move row up
ii) curr < target, move col right
Iterative solution
T: O(n + m) where n is row and m is col
S: O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        
        while((row >= 0 && row <= matrix.length - 1) && (col >= 0 && col <= matrix[0].length - 1)){
            if(matrix[row][col] > target) row--;
            else if(matrix[row][col] < target) col++;
            else return true;
        }
        
        return false;
    }
}