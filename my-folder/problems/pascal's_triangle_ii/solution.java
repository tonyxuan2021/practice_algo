// Approach 3: Memory-efficient DP
// T: O(k^2) - same as previous DP approach
// O: O(k) - no extra space is used other than required to hold the output
// pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
// WRITE pascal[i][j] (after generating from pascal[i-1][j-1] + pascal[i-1][j])
// READ pascal[i][j] to generate pascal[i+1][j]
// READ pascal[i][j] to generate pascal[i+1][j+1]

// once we get pascal[i][j] we don't need to modify it and its only read twice (DP)

// If we manage to keep all read accesses on prev row of pascal[j], before any write access to pascal[j] for the curr row value, we should be good. That's possible by evaluating each row from the END (instead of the beginning). Otherwise you'll update twice and get incorrect sum.
// new role value of pascal[j+1] must be generated before pascal[j]

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        
        for(int i = 0; i < rowIndex; i++){
            // evaluate from the end instead of the front
            for(int j = i; j > 0; j--){
                row.set(j, row.get(j) + row.get(j - 1));
            }
            
            row.add(1);
        }
        
        return row;
    }
}