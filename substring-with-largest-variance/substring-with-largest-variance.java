//modified Kadane's algorithm

class Solution {
    private int helper(String s,int res,char ch1,char ch2)
    {
        int cnt1=0;
        int cnt2=0;

        for (char ch: s.toCharArray())
        {
            if (ch==ch1 || ch==ch2)
            {
            if (ch==ch1)
                cnt1++;

            if (ch==ch2)
                cnt2++;

            if (cnt1<cnt2)
                cnt1=cnt2=0;

            if (cnt1>0 && cnt2>0)
                res=Math.max(cnt1-cnt2,res);
            }
        }

        return res;
    }

    public int largestVariance(String s) {
        int res=0;
        int[] freq=new int[26];
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        String sRev=sb.toString();

        for (char ch: s.toCharArray())
            freq[ch-'a']++;

        for (int i=0;i<26;i++)
        {
            char ch1=(char)(97+i);
            for (int j=0;j<26;j++)
            {
                char ch2=(char)(97+j);
                if (ch1==ch2 || freq[i]==0 || freq[j]==0)
                    continue;

                res=helper(s,res,ch1,ch2);
                res=helper(sRev,res,ch1,ch2);
            }
        }

        return res;
    }
}