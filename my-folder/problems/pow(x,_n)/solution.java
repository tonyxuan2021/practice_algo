// Fast Power Algorithm Recursive
// assume we have result of x^n, how do we get x^(2n)?
// we can do (x^n) * ^2 to get x^(2n) at cost of only 1 computation

// assume we have result x^(n/2) and we want to get result of x^n
// Let A be result of x^(n/2), we can talk about x^n based on parity of n respectively. 
// if n is even, we cn use formula (x^n)*^2 to get x^(2 * n) to get x^n = A * A.
// if n is odd, then A *A = x^(n - 1). We ned to multiple another x to the result so x^n = A *A * x
// This can be easily implemented using recursion. We call this "Fast Power" because we need at most O(logn) computation to get x^n.
class Solution {
    private double fastPow(double x, long n){
        if(n == 0) return 1.0;
        
        double half = fastPow(x, n/2);
        
        // if n is even
        if(n % 2 == 0) return half * half;
        // else if n is odd
        else return half * half * x;
    }
    
    
    public double myPow(double x, int n) {
        long N = n; // I guess you never want to change the inputs
        
        // case if n is negative exponent
        if(N < 0){
            x = 1 / x;
            N = -N;
        }    
        
        return fastPow(x, N);
    }
}