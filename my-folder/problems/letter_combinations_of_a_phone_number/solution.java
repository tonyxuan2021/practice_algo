// T: O(4^n * n) => n is length of digits, 4 is max value length in HASHMAP (not length of input)
// S: O(n) - where n is length of digits -> recursion call stack 
class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", 
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    private String phoneDigits;
    
    public List<String> letterCombinations(String digits) {
        // if input is empty
        if(digits.length() == 0) return combinations;
        
        // initiate backtracking with empty path and starting index 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        
        return combinations;
    }
    
    // use backtracking to generate all possible combinations
    // takes 2 input: index - we are checking, path - current combination of letters
    private void backtrack(int index, StringBuilder path){
        // base case: if path is same length as digits, we have complete combination
        if(path.length() == phoneDigits.length()){
            // path StringBuilder and convert it to String and add it to our combinations List<String>
            combinations.add(path.toString());
            // backtrack
            return; 
        }
        
        // otherwise: get all the letters that correspond with the current digit maps to and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index)); // **not 100% sure about this
        
        // loop through possibleLetters
        for(char letter : possibleLetters.toCharArray()){
            // add letter to curr path
            path.append(letter);
            // call backtrack again but move onto the next digit by incrementing index + 1
            backtrack(index + 1, path);
            // backtrack by removing letter before moving to next
            path.deleteCharAt(path.length() - 1);
        }
    }
}

/* 
Given string containing digits from 2-9 inclusive, return all possible letter combinations that number can represent -> return answer in any order (note 1 does not map to any letters)

// overview: look at constraints
// length of input is extremely small => 0 to 4 so we can safely assume brute force solution will be accepted
// backtracking algo -> keep the SPACE complexity linear with input size

// difficult part: figuring out how to correctly generate all possible combinations and to do this using a standard backtracking algorithm template

// breakdown: start with input 1 digit long, e.g. digits = "2"
// just generate all letters correspond with digit = "2" which is "a", "b", "c"

// what is we had 2-digit input, e.g. digits = "23"
// imagine we take "2" as starting point - we LOCK the first letter in and solve all possible combinations that start with that letter

// in our first letter will always be "a", then problem is trivial again. 
// generate all letters corresponding with digit = "3" and add that to "a" ->
// "ad", "ae", "af"

// solving 1 digit is trivial, solving 2 digit is just solving 1-digit twice
// solving 3 digit, solve the 2 digit case to generate all combo of first 2 letters, then solve the 1 digit case for the final digit. Now we know 3 digit, we can solve 4 digit

// algo: lock-in letters when we generate new letters (easiest way to save state is recursion)

// if input is empty, return empty arr
// initialize DS (e.g. hashmap) that maps digits to letters for e.g. mapping 6 to m, n, o
// use backtrack fx to generate all possible combo
// fx takes 2 inputs: current combinations of letters we have (path) and index we are checking 
// base case: if curr combo letter == lenght of digits, we complete combo -> add to answer and backtrack
// otherwise, get all letters that correspond with curr digit we are looking at digits[index]
// loop through these letters, for each letter, add letter to curr path and call backtrack, move on to next digit by inc index + 1
// make sure to remove the letter from path once we finished with it
*/