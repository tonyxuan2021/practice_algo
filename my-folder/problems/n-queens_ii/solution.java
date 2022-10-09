/* 
backtrack:
- make sure we only place 1 queen per row, we pass an int arg row into backtrack
and only place one queen each call. When we place a queen, we move onto next row by calling backtrack again with row+1
- to make sure we only place 1 queen per col, whenever we place a queen, we add the col index to this set
- diagonal is a bit trickier but for each square, diff b/ween row and col index is constant. 
- diagonal diff is always 0 
- for each square on a given anti-diagonal, sum of (row + col) is always constant. if you start at highest square in anti-diagonal and move downwards the row incr. 1 (row + 1), and col index dec by 1 (col - 1). These cancel each other out.
- whenever we place a queen, we should calculate the diagonal and anti-diagonal value it belongs to. In the same way we had a set for col, we should have a set for both diagonals and anti-diagonals. Then we put values for this queen in corresponding set.

algo:
We create a recursive fx backtrack that takes 4 arg to maintain board state. First param is the row we're going to place a queen on next and the other 3 are set that track which col, diagonal, and anti-diagonal have already had queens placed on them. 

FX works as follows:
1. If curr row is greater than n, we have resolution - return 1
2. Initiate a local var solutions = 0, that represents all possible solutions that can be obtained from curr board state 
3. Iterate through col (width) of curr row. At each col, we attempt to place a queen - remember we consider the curr row through the fx arg 
    - calc diagonal and anti-diagonal that square belongs to. If there is no queen placed yet in col, diagonal, and anti-diagonal, then we can place a queen in this col in curr row
    - if we can't place the queen, skip this col (move on to try next col)
4. If we were able to place a queen, update our 3 sets (col, diagonal, antiDiagonals), and call the fx again but with row + 1
5. The fx call made in step 4 explores all valid board states with the queen we placed in step 3. Since we're done exploring that path, backtrack by removing the queen from the square - this just means removing the values we added to our sets.
*/
class Solution {
    private int size;
    
    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }
    
    private int backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols){
        // base case - N queens have been placed
        if(row == size) return 1;
        
        int solutions = 0;
        for(int col = 0; col < size; col++){
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            
            // if queen is not placeable
            if(cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) continue;
            
            // add queen to the board
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            
            // move onto the next row with udpated board state
            solutions += backtrack(row + 1, diagonals, antiDiagonals, cols);
            
            // remove the queen from the board since we already have explored all valid paths using above fx call
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }
        
        return solutions;
    }
}