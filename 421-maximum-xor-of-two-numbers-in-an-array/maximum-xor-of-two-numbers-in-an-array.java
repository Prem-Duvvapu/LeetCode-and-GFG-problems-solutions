class TrieNode {
    TrieNode[] arr;

    TrieNode() {
        arr = new TrieNode[2];
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode curr = root;

        for (int i=31;i>=0;i--) {
            int currBit = ((num >> i) & 1);
            if (curr.arr[currBit] == null)
                curr.arr[currBit] = new TrieNode();

            curr = curr.arr[currBit];
        }
    }

    public int getMaxXoR(int num) {
        int res = 0;
        TrieNode curr = root;

        for (int i=31;i>=0;i--) {
            int currBit = ((num >> i) & 1);

            if (curr.arr[1 - currBit] != null) {
                res += (1<<i);
                curr = curr.arr[1 - currBit];
            } else {
                curr = curr.arr[currBit];
            }
        }

        return res;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int maxRes = 0;
        Trie trie = new Trie();

        for (int val: nums)
            trie.insert(val);

        for (int val: nums)
            maxRes = Math.max(maxRes, trie.getMaxXoR(val));

        return maxRes;
    }
}