class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int right=0;
        int maxLen=0;
        int[] freq=new int[26];
        int maxFreq=0;

        while (right<n) {
            char ch=s.charAt(right);
            freq[ch-'A']++;
            maxFreq=Math.max(maxFreq,freq[ch-'A']);

            while ((right-left+1)-maxFreq > k) {
                freq[s.charAt(left)-'A']--;

                maxFreq=0;
                for (int i=0;i<26;i++)
                    maxFreq=Math.max(maxFreq,freq[i]);

                left++;
            }

            if ((right-left+1)-maxFreq <= k)
                maxLen=Math.max(maxLen,right-left+1);

            right++;
        }

        return maxLen;
    }
}