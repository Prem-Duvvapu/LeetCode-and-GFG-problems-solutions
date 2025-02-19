class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=0;
        int start=-1;
        int currLen=0;

        for (int i=0;i<n;i++) {
            int left=i-1;
            int right=i+1;

            while (left>=0 && s.charAt(left)==s.charAt(i))
                left--;

            while (right<n && s.charAt(right)==s.charAt(i))
                right++;

            while (left>=0 && right<n) {
                if (s.charAt(left)==s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            currLen=right-left-1;
            if (currLen>maxLen) {
                maxLen=currLen;
                start=left+1;
            }
        }

        return s.substring(start,start+maxLen);
    }
}