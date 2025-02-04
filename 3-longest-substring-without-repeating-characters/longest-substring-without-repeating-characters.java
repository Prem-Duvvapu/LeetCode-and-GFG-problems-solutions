//Optimal
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxLen=0;
        int left=0;
        int right=0;
        int[] hash=new int[256];
        Arrays.fill(hash,-1);

        while (right<n) {
            if (hash[s.charAt(right)]!=-1 && hash[s.charAt(right)]>=left)
                left=hash[s.charAt(right)]+1;

            int currLen=right-left+1;
            maxLen=Math.max(maxLen,currLen);
            hash[s.charAt(right)]=right;
            right++;
        }

        return maxLen;
    }
}