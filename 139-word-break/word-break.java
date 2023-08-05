class TrieNode
{
    TrieNode[] children;
    boolean endOfWord;

    TrieNode()
    {
        children=new TrieNode[26];
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
            if (curr.children[ch-'a']==null)
                curr.children[ch-'a']=new TrieNode();
            
            curr=curr.children[ch-'a'];
        }
        curr.endOfWord=true;
    }

    public boolean search(String word)
    {
        TrieNode curr=root;
        for (char ch: word.toCharArray())
        {
            if (curr.children[ch-'a']==null)
                return false;

            curr=curr.children[ch-'a'];
            
        }
        return curr.endOfWord;
    }
}

class Solution {
    private boolean solve(int pos,String s,Trie t,int[] dp)
    {
        if (pos==s.length() || dp[pos]==1)
            return true;
        
        if (dp[pos]==0)
            return false;

        for (int i=pos;i<s.length();i++)
        {
            String sub=s.substring(pos,i+1);
            if (t.search(sub))
            {
                if (solve(pos+sub.length(),s,t,dp))
                {
                    dp[pos]=1;
                    return true;
                }
            }
        }

        dp[pos]=0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        Trie t=new Trie();
        for (String word: wordDict)
            t.insert(word);
        return solve(0,s,t,dp);
    }
}