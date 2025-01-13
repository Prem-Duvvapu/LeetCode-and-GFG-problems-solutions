class Node {
    Node[] chars;
    boolean flag;

    Node() {
        chars = new Node[26];
        flag=false;
    }

    boolean containsKey(char ch) {
        return (chars[ch-'a']!=null);
    }

    Node insertChar(char ch) {
        chars[ch-'a']=new Node();
        return chars[ch-'a'];
    }

    void setEnd(){
        flag=true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for (char ch: word.toCharArray()) {
            if (curr.containsKey(ch))
                curr=curr.chars[ch-'a'];
            else
                curr = curr.insertChar(ch);
        }

        curr.setEnd();
    }
    
    public boolean search(String word) {
        Node curr=root;

        for (char ch: word.toCharArray()) {
            if (curr.containsKey(ch))
                curr=curr.chars[ch-'a'];
            else
                return false;
        }

        return curr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node curr=root;

        for (char ch: prefix.toCharArray()) {
            if (curr.containsKey(ch))
                curr=curr.chars[ch-'a'];
            else
                return false;
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