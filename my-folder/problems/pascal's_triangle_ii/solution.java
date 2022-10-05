class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowAns = new ArrayList<>();
        
        rowAns.add(1);
        
        // outer loop for row
        for(int i = 0; i < rowIndex; i++){
            
            // inner loop to fill in the middle columns
            for(int j = i; j > 0; j--){
                rowAns.set(j, rowAns.get(j) + rowAns.get(j - 1));
            }
            
            rowAns.add(1);
        }
        
        return rowAns;
    }
}