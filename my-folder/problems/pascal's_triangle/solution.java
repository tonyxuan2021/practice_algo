class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pTriangle = new ArrayList<>();
        // first row 
        pTriangle.add(new ArrayList<Integer>());
        // fill first row only elem with 1
        pTriangle.get(0).add(1);
        
        // outer loop for rows
        for(int rowNum = 1; rowNum < numRows; rowNum++){
            // create new ArrayList for each new row
            List<Integer> currRow = new ArrayList<>();
            // get variable for prevRow
            List<Integer> prevRow = pTriangle.get(rowNum - 1);
            
            // add 1 as first elem in currRow
            currRow.add(1);
            
            // inner loop to fill the col of currRow (except first and last elem)
            for(int colNum = 1; colNum < prevRow.size(); colNum++){
                currRow.add(prevRow.get(colNum - 1) + prevRow.get(colNum));
            }
            
            // add 1 as last elem in currRow
            currRow.add(1);
            // add currRow to pTriangle
            pTriangle.add(currRow);
        }
        
        // return our answer
        return pTriangle;
    }
}