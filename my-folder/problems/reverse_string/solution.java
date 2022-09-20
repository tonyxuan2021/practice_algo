/*
e.g. s.length = 5
input:  hello
        01234
output: olleh
        01234
*/
class Solution {
    public void reverseString(char[] s){
        helper(s, 0, s.length - 1);
    }
    
    private void helper(char[] s, int left, int right){
        if(left >= right) return;
        
        // swap s[left] with s[right] and left++ and right--
        char tmp = s[left];
        
        s[left++] = s[right];
        s[right--] = tmp;
        
        helper(s, left, right);
    }
}