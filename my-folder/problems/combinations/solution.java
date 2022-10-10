class Solution {
    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;
    
    // n is range of #, k is size of combination
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }
    
    private void backtrack(int first, LinkedList<Integer> curr){
        // if combination is done
        if(curr.size() == k) output.add(new LinkedList(curr));
        
        for(int i = first; i < n + 1; i++){
            // add i into curr combination
            curr.add(i);
            // use next integers to complete combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }
}