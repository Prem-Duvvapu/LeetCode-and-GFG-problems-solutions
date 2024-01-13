class Solution {
    public int minSteps(String s, String t) {
        int n=s.length();
        int res=0;
        int[] cntS=new int[26];

        for (char ch: s.toCharArray())
            cntS[ch-'a']++;

        for (char ch: t.toCharArray())
            cntS[ch-'a']--;

        for (int i=0;i<26;i++)
            if (cntS[i]>0)
                res+=cntS[i];

        return res;
    }
}