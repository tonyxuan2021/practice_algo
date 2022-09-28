// Trie is used to efficiently store and retrieve keys in a dataset of Strings (e.g. Google Autocomplete, spellchecker, IP routing - longest prefix matching, predictive text)
// Although hashtable has O(1) in looking for key, it's not efficient in finding all keys with common prefix and enumerating a dataset of strings in lexicographical order
// hash table icnreases in size and there can be hash collision
// Trie could use less space compared to HT when storing many keys w/ the same PREFIX
// Trie has O(m) time complexity, where m is the key length
// Searching for a key in a balanced tree costs O(mlogn)

// nodes have max of r links (26 lowercase latin letters)
// bool field which specifies whether node corresponds to end of the key or key prefix

// https://leetcode.com/problems/implement-trie-prefix-tree/discuss/58832/AC-JAVA-solution-simple-using-single-array

class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    // Initialize your data structure here.
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ws.children[ch - 'a'] == null){
                ws.children[ch - 'a'] = new TrieNode();
            }
            ws = ws.children[ch - 'a'];
        }
        ws.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode ws = searchHelper(word);
        return ws != null && ws.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
         return searchHelper(prefix) != null;
    }
    
    public TrieNode searchHelper(String key){
        TrieNode ws = root;
        for(int i = 0; i < key.length() && ws != null; i++){
            char ch = key.charAt(i);
            ws = ws.children[ch - 'a'];
        }
        return ws;
    }
}