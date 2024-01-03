class Solution {
    public int numberOfBeams(String[] bank) {
        int m=bank.length;
        int n=bank[0].length();
        int prev=0;
        int res=0;

        for (int i=0;i<m;i++) {
            int curr=0;
            for (int j=0;j<n;j++) {
                curr+=(bank[i].charAt(j)-'0');
            }
            res+=(prev*curr);
            if (curr>0)
                prev=curr;
        }

        return res;
    }
}