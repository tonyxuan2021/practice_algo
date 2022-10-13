// Nick White solution
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output_arr = new ArrayList<>();
        backtrack(output_arr, "", 0, 0, n);
        return output_arr;
    }
    
    // backtrack
    private void backtrack(List<String> output_arr, String current_string, int open, int close, int max){
        // base case: * 2 because there's open and close
        if(current_string.length() == max * 2){
            output_arr.add(current_string);
            return;
        }
        
        // handle decisions (call all possible solution):
        // max is max. number of open and close 
        // current_string + "(" because open is not at max capacity
        if(open < max) backtrack(output_arr, current_string + "(", open + 1, close, max); 
        // we cannot have close paren before open paren
        if(close < open) backtrack(output_arr, current_string + ")", open, close + 1, max);
    }
}