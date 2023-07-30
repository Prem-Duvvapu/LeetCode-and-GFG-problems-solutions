class TrieNode
{
    Map<Character,TrieNode> children;
    boolean endOfWord;

    TrieNode()
    {
        children=new HashMap<>();
        endOfWord=false;
    }
}

class Trie
{
    TrieNode root;

    Trie()
    {
        root=new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode curr=root;
        for (char ch: word.toCharArray())
        {
            if (!curr.children.containsKey(ch))
                curr.children.put(ch,new TrieNode());
            curr=curr.children.get(ch);
        }
        curr.endOfWord=true;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie t=new Trie();
        for (String word: strs)
            t.insert(word);

        StringBuilder res=new StringBuilder();
        TrieNode curr=t.root;
        
        if (curr.endOfWord)
            return "";
        
        while (true) 
        {
            if (curr.children.size()!=1)
                break;

            for (Map.Entry<Character,TrieNode> m: curr.children.entrySet())
            {
                res.append(m.getKey());
                curr=m.getValue();
            }

            if (curr.endOfWord)
                break;
        }

        return res.toString();
    }
}