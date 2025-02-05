class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int left=0;
        int right=0;
        int[] hash=new int[256];
        int cnt=0;
        int minLen=(int)1e8;
        int startIndex=-1;

        for (char ch: t.toCharArray())
            hash[ch]++;

        while (right < n) {
            char ch=s.charAt(right);
            hash[ch]--;

            if (hash[ch]>=0)
                cnt++;

            while (cnt == m) {
                if ((right-left+1) < minLen) {
                    minLen=right-left+1;
                    startIndex=left;
                }

                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)]>0)
                    cnt--;
                left++;
            }

            right++;
        }

        if (startIndex==-1)
            return "";

        return s.substring(startIndex,startIndex+minLen);
    }
}