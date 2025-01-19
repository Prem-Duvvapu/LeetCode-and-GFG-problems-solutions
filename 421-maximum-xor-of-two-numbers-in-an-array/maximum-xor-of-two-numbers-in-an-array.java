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

    public Node getNode(int bit) {
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
            int bit = (num>>i)&1;
            if (!curr.containsBit(bit))
                curr.insertBit(bit);
            
            curr = curr.getNode(bit);
        }
    }

    public int getMax(int num) {
        Node curr=root;
        int maxNum=0;

        for (int i=31;i>=0;i--) {
            int bit=(num >> i)&1;

            if (curr.containsBit(1-bit)) {
                maxNum = (maxNum | (1<<i));
                curr = curr.getNode(1-bit);
            } else {
                curr = curr.getNode(bit);
            }
        }

        System.out.println(maxNum);

        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        Trie t=new Trie();
        int maxVal=0;

        for (int i=0;i<n;i++)
            t.insertNum(nums[i]);

        for (int i=0;i<n;i++)
            maxVal=Math.max(maxVal, t.getMax(nums[i]));

        return maxVal;
    }
}