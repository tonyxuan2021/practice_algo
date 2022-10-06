//      0, 1, 1, 2, 3
// idx: 0  1  2  3  4
class Solution {
    // using memoization
    // populate map right away with (0, 0, 1, 1)
    private Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));
    
    public int fib(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        
        // top-down approach, we get from our result back to the base
        // recursion
        cache.put(n, fib(n-1) + fib(n-2));
        
        return cache.get(n);
    }
}