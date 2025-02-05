class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int aLastSeen=-1;
        int bLastSeen=-1;
        int cLastSeen=-1;
        int cnt=0;

        for (int i=0;i<n;i++) {
            if (s.charAt(i)=='a')
                aLastSeen=i;
            else if (s.charAt(i)=='b')
                bLastSeen=i;
            else
                cLastSeen=i;

            if (aLastSeen!=-1 && bLastSeen!=-1 && cLastSeen!=-1)
                cnt+=(Math.min(aLastSeen,Math.min(bLastSeen,cLastSeen))+1);
        }

        return cnt;
    }
}