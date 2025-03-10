class TrieNode {
    TrieNode[] charExist;
    boolean endOfWord;

    TrieNode() {
        charExist=new TrieNode[26];
        endOfWord=false;
    }
}


class Trie {
    TrieNode root;

    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr=root;

        for (char ch: word.toCharArray()) {
            if (curr.charExist[ch-'a']!=null) {
                curr=curr.charExist[ch-'a'];
            } else {
                TrieNode newNode=new TrieNode();
                curr.charExist[ch-'a']=newNode;
                curr=curr.charExist[ch-'a'];
            }
        }

        curr.endOfWord=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;

        for (char ch: word.toCharArray()) {
            if (curr.charExist[ch-'a']==null)
                return false;

            curr=curr.charExist[ch-'a'];
        }

        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;

        for (char ch: prefix.toCharArray()) {
            if (curr.charExist[ch-'a']==null)
                return false;

            curr=curr.charExist[ch-'a'];
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