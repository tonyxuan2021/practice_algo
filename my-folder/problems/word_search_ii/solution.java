// Backtracking with Trie
class TrieNode {
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  String word = null;
  public TrieNode() {}
}

class Solution {
  char[][] _board = null;
  ArrayList<String> _result = new ArrayList<String>();

  public List<String> findWords(char[][] board, String[] words) {

    // Step 1). Construct the Trie
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode node = root;

      for (Character letter : word.toCharArray()) {
        if (node.children.containsKey(letter)) {
          node = node.children.get(letter);
        } else {
          TrieNode newNode = new TrieNode();
          node.children.put(letter, newNode);
          node = newNode;
        }
      }
      node.word = word;  // store words in Trie
    }

    this._board = board;
    // Step 2). Backtracking starting for each cell in the board
    for (int row = 0; row < board.length; ++row) {
      for (int col = 0; col < board[row].length; ++col) {
        if (root.children.containsKey(board[row][col])) {
          backtracking(row, col, root);
        }
      }
    }

    return this._result;
  }
  
  private void backtracking(int row, int col, TrieNode parent) {
    Character letter = this._board[row][col];
    TrieNode currNode = parent.children.get(letter);

    // check if there is any match
    if (currNode.word != null) {
      this._result.add(currNode.word);
      currNode.word = null;
    }

    // mark the current letter before the EXPLORATION
    this._board[row][col] = '#';

    // explore neighbor cells in around-clock directions: up, right, down, left
    int[] rowOffset = {-1, 0, 1, 0};
    int[] colOffset = {0, 1, 0, -1};
    for (int i = 0; i < 4; ++i) {
      int newRow = row + rowOffset[i];
      int newCol = col + colOffset[i];
      if (newRow < 0 || newRow >= this._board.length || newCol < 0
          || newCol >= this._board[0].length) {
        continue;
      }
      if (currNode.children.containsKey(this._board[newRow][newCol])) {
        backtracking(newRow, newCol, currNode);
      }
    }

    // End of EXPLORATION, restore the original letter in the board.
    this._board[row][col] = letter;

    // Optimization: incrementally remove the leaf nodes
    if (currNode.children.isEmpty()) {
      parent.children.remove(letter);
    }
  }
}


/*
Simplified crossword puzzle game, where word solutions have been given on the board. All we need to do is cross them out.

Intuitively: iterate cell one by one and from each cell we walk along its neighbors in 4 potential directions to find matched words. While wandering, we will stop exploration when we know it will not lead to discovery of new words.

backtracking 

How do we find the matches of word from dictionary? Intuitively, one can use hashset DS. This could work.

During backtracking, you would encounter more often need to tell if there are any word that contains PREFIX, rather than if string exists as a word in the dictionary. If there is no match for given prefix, we don't need to explore futher. This will reduce exploration space and improve performance of backtracking algo.

Matching prefix is where Trie will shine. 

Overall flow of algo is intuitive, consists of a loop over each cell in the board and a recursive fx call starting from the cell. 

- Build Trie out of word in dictionary
- Starting from each cell, we start the backtracking exploration (i.e. backtracking (cell)), if there exists any word in the dictionary that starts with the letter in the cell
- During recursive fx call backtracking(cell), we explore neighbor cells around curr cell for next recursive call backtracking(neighborCell). At each call, we check if sequence of letters that we traverse so far matches any word in the dictionary, with help of Trie DS.



*/