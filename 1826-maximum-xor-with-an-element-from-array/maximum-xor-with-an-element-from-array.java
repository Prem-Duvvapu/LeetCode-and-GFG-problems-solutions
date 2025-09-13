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

    public int getMaxXOR(int num) {
        int res = 0;
        TrieNode curr = root;

        for (int i=31;i>=0;i--) {
            int currBit = ((num >> i) & 1);

            if (curr.arr[1 - currBit] != null) {
                res += (1 << i);
                curr = curr.arr[1 - currBit];
            } else {
                curr = curr.arr[currBit];
            }
        }

        return res;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] res = new int[q];
        int[][] arr = new int[q][3];
        Trie trie = new Trie();

        for (int i=0;i<q;i++) {
            arr[i][0] = queries[i][0];
            arr[i][1] = queries[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (x,y) -> Integer.compare(x[1],y[1]));
        Arrays.sort(nums);

        int pos = 0;
        for (int i=0;i<q;i++) {
            if (nums[0] > arr[i][1]) {
                res[arr[i][2]] = -1;
                continue;
            }

            while (pos < n && nums[pos] <= arr[i][1]) {
                trie.insert(nums[pos]);
                pos++;
            }

            res[arr[i][2]] = trie.getMaxXOR(arr[i][0]);
        }

        return res;
    }
}