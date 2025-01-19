class Node {
    Node[] bits;

    Node() {
        bits=new Node[2];
    }

    public boolean containsBit(int bit) {
        return (bits[bit]!=null);
    }

    public void insertBit(int bit) {
        bits[bit]=new Node();
    }

    public Node getBit(int bit) {
        return bits[bit];
    }
}

class Trie {
    Node root;

    Trie() {
        root=new Node();
    }

    public void insertNum(int num) {
        Node curr=root;

        for (int i=31;i>=0;i--) {
            int bit=(num >> i)&1;

            if (!curr.containsBit(bit))
                curr.insertBit(bit);
            
            curr=curr.getBit(bit);
        }
    }

    public int getMax(int num) {
        Node curr=root;
        int maxVal=0;

        for (int i=31;i>=0;i--) {
            int bit=(num >> i)&1;

            if (curr.containsBit(1-bit)) {
                maxVal = (maxVal | (1 << i));
                curr=curr.getBit(1-bit);
            } else {
                curr=curr.getBit(bit);
            }
        }

        return maxVal;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        int[] res=new int[m];
        int[][] queriesWithIndex=new int[m][3];
        Trie t=new Trie();
        int index=0;

        for (int i=0;i<m;i++) {
            queriesWithIndex[i][0]=queries[i][0];
            queriesWithIndex[i][1]=queries[i][1];
            queriesWithIndex[i][2]=i;
        }

        Arrays.sort(nums);
        Arrays.sort(queriesWithIndex, (a,b) -> Integer.compare(a[1],b[1]));

        for (int i=0;i<m;i++) {
            int num = queriesWithIndex[i][0];
            int maxLimitNum = queriesWithIndex[i][1];
            int resIndex=queriesWithIndex[i][2];

            if (nums[0] > maxLimitNum) {
                res[resIndex]=-1;
                continue;
            }
            
            while (index<n && nums[index] <= maxLimitNum) {
                System.out.println(index);
                System.out.println(maxLimitNum);
                t.insertNum(nums[index]);
                index++;
            }

            res[resIndex]=t.getMax(num);
        }

        return res;
    }
}