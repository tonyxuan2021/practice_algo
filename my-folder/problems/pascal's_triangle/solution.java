// Dynamic Programming - recursion with memoization
// 1 on left and right sides of each row
// all other numbers are sum of 2 numbers above
// easier if we visualize triangle left aligned
// DP:
// 1) optimal substructure 
// 2) overlapping subproblems - some are used more than once
// base case: value at beg and end is 1
// recurrence: each # is sum of two #s above it
// triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col]
// T: O(numRows ^ 2)
// S: O(1) - input and output generally do not count towards space complexity
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // add first row
        triangle.add(new ArrayList<>());
        // first row only has 1 single elem
        triangle.get(0).add(1);
        
        for(int rowNum = 1; rowNum < numRows; rowNum++){
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);
            currRow.add(1); // base case
            
            for(int col = 1; col < prevRow.size(); col++){
                currRow.add(prevRow.get(col - 1) + prevRow.get(col));
            }
            
            currRow.add(1);
            triangle.add(currRow);
        }
        
        return triangle;
    }
}