class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxLength=0;
        int left=0;
        int[] recentIndex=new int[256];
        Arrays.fill(recentIndex,-1);

        for (int right=0;right<n;right++)
        {
            char ch=s.charAt(right);

            if (recentIndex[(int)ch]!=-1)
                left=Math.max(left,recentIndex[(int)ch]+1);

            recentIndex[(int)ch]=right;
            maxLength=Math.max(maxLength,right-left+1);
        }

        return maxLength;
    }
}