class TrieNode {
    TrieNode[] arr;

    TrieNode() {
        arr=new TrieNode[2];
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root=new TrieNode();
    }

    public void insert(int num) {
        TrieNode curr=root;

        for (int i=31;i>=0;i--) {
            int currBit=((num>>i)&1);

            if (curr.arr[currBit]==null)
                curr.arr[currBit]=new TrieNode();

            curr=curr.arr[currBit];
        }
    }

    public int check(int num) {
        TrieNode curr=root;
        int xorVal=0;

        for (int i=31;i>=0;i--) {
            int currBit=((num>>i)&1);

            if (curr.arr[1-currBit]!=null) {
                xorVal=(xorVal|(1<<i));
                curr=curr.arr[1-currBit];
            } else {
                curr=curr.arr[currBit];
            }
        } 

        return xorVal;       
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        Trie trie=new Trie();
        int maxXor=0;

        for (int val: nums)
            trie.insert(val);

        for (int val: nums)
            maxXor=Math.max(maxXor,trie.check(val));

        return maxXor;
    }
}