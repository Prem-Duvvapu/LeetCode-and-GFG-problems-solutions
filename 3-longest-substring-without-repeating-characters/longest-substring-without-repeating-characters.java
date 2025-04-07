class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int[] lastOccurence=new int[256];
        int currLen=0;
        int maxLen=0;
        int left=0;
        int right=0;

        int firstIndex=-1;
        int lastIndex=-1;

        Arrays.fill(lastOccurence,-1);

        while (right<n) {
            char ch=s.charAt(right);

            if (lastOccurence[ch]!=-1)
                left=Math.max(left,lastOccurence[ch]+1);

            currLen=right-left+1;
            maxLen=Math.max(maxLen,currLen);

            lastOccurence[ch]=right;
            right++;
        }

        return maxLen;
    }
}

/*
time: O(n)
space: O(1)

3. return all substrings 


s = "a b c a b c b b"
     0 1 2 3 4 5 6 7


brute:
maxLength=3
set={b,c}

a
ab
abc
abca

b
bc

time: O(n*n)
space: O(256)


optimal:

"e b a b c d b a"
 0 1 2 3 4 5 6 7
             r
     l  

int lastOccurence[]
128
            a  b   c  d  e
0 1 2 3 .. .96 97 98 99 100.. 127
-1 -1 -1    7  6   4  5  0

l=4 max(l,update with lastOccurence[ch]+1)
r=7

maxLen=4;
currLen=r-l+1 = 7-4+1 = 4

maxLen=max(maxLen,currLen)

a to z
A to Z
1 to 9

expected ans: len=4 (abcd/cdba)

*/