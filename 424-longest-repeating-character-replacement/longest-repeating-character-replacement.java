class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int right=0;
        int maxLen=0;
        int[] freq=new int[26];

        while (right<n) {
            char ch=s.charAt(right);
            freq[ch-'A']++;
            int maxFreq=0;
            int totalFreq=0;

            for (int i=0;i<26;i++) {
                totalFreq+=freq[i];
                maxFreq=Math.max(maxFreq,freq[i]);
            }

            int diff=totalFreq-maxFreq;

            while (diff>k) {
                freq[s.charAt(left)-'A']--;
                left++;
                totalFreq--;
                diff=totalFreq-maxFreq;
            }

            if (diff<=k)
                maxLen=Math.max(maxLen,right-left+1);

            right++;
        }

        return maxLen;
    }
}