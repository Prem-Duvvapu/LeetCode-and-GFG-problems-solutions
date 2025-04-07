class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int[] lastOccurence=new int[256];
        int maxLength=0;
        int left=0;
        int right=0;

        Arrays.fill(lastOccurence,-1);

        while (right<n) {
            char ch=s.charAt(right);
            if (lastOccurence[ch]!=-1)
                left=Math.max(left,lastOccurence[ch]+1);
            
            int currLength=right-left+1;
            maxLength=Math.max(maxLength,currLength);
            lastOccurence[ch]=right;

            right++;
        }

        return maxLength;
    }
}