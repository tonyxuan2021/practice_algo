// brute force will not work because each row doubles 2^30 is a really large number
// Recursion (Parent Variant)
class Solution {
    // n is row # - 1-indexed
    // k is digit within the row # - 1-indexed
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        return (~k & 1) ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}