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

    public int getMax(int num) {
        TrieNode curr=root;
        int maxXor=0;

        for (int i=31;i>=0;i--) {
            int currBit=((num>>i)&1);

            if (curr.arr[1-currBit]!=null) {
                maxXor+=(1<<i);
                curr=curr.arr[1-currBit];
            } else {
                curr=curr.arr[currBit];
            }
        }

        return maxXor;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n=nums.length;
        int qlen=queries.length;
        int[] res=new int[qlen];
        Trie trie=new Trie();
        Integer[] queryIndex=new Integer[qlen];

        for (int i=0;i<qlen;i++)
            queryIndex[i]=i;

        Arrays.sort(nums);
        Arrays.sort(queryIndex, (x,y) -> Integer.compare(queries[x][1],queries[y][1]));

        int pos=0;
        for (int i=0;i<qlen;i++) {
            int index=queryIndex[i];
            int num=queries[index][0];
            int m=queries[index][1];

            if (nums[0]>m) {
                res[index]=-1;
                continue;
            }

            while (pos<n && nums[pos]<=m) {
                trie.insert(nums[pos]);
                pos++;
            }

            res[index]=trie.getMax(num);
        }

        return res;
    }
}