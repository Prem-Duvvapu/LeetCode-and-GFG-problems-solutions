class Solution {
    public int numSplits(String s) {
        int n=s.length();
        int[] frontDistinct=new int[n];
        int[] backDistinct=new int[n];

        Set<Character> set=new HashSet<>();
        for (int i=0;i<n;i++)
        {
            set.add(s.charAt(i));
            frontDistinct[i]=set.size();
        }

        set.clear();
        for (int i=n-1;i>=0;i--)
        {
            set.add(s.charAt(i));
            backDistinct[i]=set.size();
        }

        int cnt=0;
        for (int i=0;i<n-1;i++)
            if (frontDistinct[i]==backDistinct[i+1])
                cnt++;

        return cnt;
    }
}