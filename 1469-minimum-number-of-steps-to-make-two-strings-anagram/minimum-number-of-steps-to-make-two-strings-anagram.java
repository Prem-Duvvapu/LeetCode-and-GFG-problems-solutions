class Solution {
    public int minSteps(String s, String t) {
        int n=s.length();
        int res=0;
        int[] cntS=new int[26];
        int[] cntT=new int[26];

        for (char ch: s.toCharArray())
            cntS[ch-'a']++;

        for (char ch: t.toCharArray())
            cntT[ch-'a']++;

        for (int i=0;i<26;i++)
            res+=Math.max(0,cntS[i]-cntT[i]);

        return res;
    }
}