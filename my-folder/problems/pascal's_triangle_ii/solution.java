// Approach 2: DP
// T: O(k^2) - calculating a row requires calc all prev rows as well 
// S: O(k) - saving space keeping only the latest generated row, we only need O(k) extra space other than the O(k) required to store the output
// keep only the latest row generated and use that to generate a new row
class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> curr;
    List<Integer> prev = new ArrayList<>(); 
    prev.add(1);  

    // outer loop for row
    for(int i = 1; i <= rowIndex; i++){
        // create a new ArrayList with a size 1 bigger 
        curr = new ArrayList<>(i + 1); 
        // add 1 to the beg 
        curr.add(1);

        // inner loop for filling the col (except first and last elem (which is 1))
        for(int j = 1; j < i; j++){
            curr.add(prev.get(j - 1) + prev.get(j));
        }

        // add 1 to the end
        curr.add(1);

        // update prev to be curr
        prev = curr;
    }

    return prev;
  }
}