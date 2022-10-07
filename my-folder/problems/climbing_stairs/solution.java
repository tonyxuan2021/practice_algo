// similar to fib number -> add last two 
// DP bottom up approach - optimized
// optimized because to calculate new step, we only need to keep last step and the step before it
// T: O(n) - we perf constant op on every stair case
// S: O(1) 
class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        
        int first = 1;
        int second = 2;
        
        for(int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        
        return second;
    }
}