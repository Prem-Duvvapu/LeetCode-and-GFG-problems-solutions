class TrieNode {
    TrieNode[] arr;
    boolean endOfWord;

    TrieNode() {
        arr=new TrieNode[26];
        endOfWord=false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root=new TrieNode();
    }
    
    //Time: O(word)
    public void insert(String word) {
        TrieNode curr=root;

        for (char ch: word.toCharArray()) {
            if (curr.arr[ch-'a']==null)
                curr.arr[ch-'a']=new TrieNode();
            
            curr=curr.arr[ch-'a'];
        }

        curr.endOfWord=true;
    }
    
    //Time: O(word)
    public boolean search(String word) {
        TrieNode curr=root;

        for (char ch: word.toCharArray()) {
            if (curr.arr[ch-'a']==null)
                return false;
            
            curr=curr.arr[ch-'a'];
        }

        return curr.endOfWord;
    }
    
    //Time: O(prefix)
    public boolean startsWith(String prefix) {
        TrieNode curr=root;

        for (char ch: prefix.toCharArray()) {
            if (curr.arr[ch-'a']==null)
                return false;
            
            curr=curr.arr[ch-'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */