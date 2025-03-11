class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] lastSeen=new int[3];
        int res=0;

        Arrays.fill(lastSeen,-1);

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            lastSeen[ch-'a']=i;

            if (lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1) {
                int minIndex=Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
                res+=(minIndex+1);
            }
        }

        return res;
    }
}