//Backtracking 

class Solution {
    
    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first){
        // if all integers are used up
        if(first == n) output.add(new ArrayList<Integer>(nums));
        
        for(int i = first; i < n; i++){
            // place ith integer first in the current permutation
            Collections.swap(nums, first, i);
            
            // use next integers to complete the permutation
            backtrack(n, nums, output, first + 1);
            
            // backtrack
            Collections.swap(nums, first, i);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        // output list LinkedList(); 
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        
        // convert nums into list since output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        
        for(int num : nums){
            nums_lst.add(num);
        }
        
        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
}