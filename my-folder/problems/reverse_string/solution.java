/* 
input:  h e l l o
idx:    0 1 2 3 4

output: o l l e h
idx:    0 1 2 3 4
*/
// T: O(n)
// S: O(1)
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        helper(s, left, right);
    }
    
    private void helper(char[] s, int left, int right){
        // base case
        if(left >= right) return;
        
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        
        helper(s, left, right);
    }
}