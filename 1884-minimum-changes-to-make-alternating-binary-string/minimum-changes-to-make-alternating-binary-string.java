class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int cnt1=0;
        int cnt2=0;

        //start with '0'
        int curr=0;
        for (char ch: s.toCharArray()) {
            if (('1'-ch)==curr)
                cnt1++;
            curr=1-curr;
        }

        //start with '1'
        curr=1;
        for (char ch: s.toCharArray()) {
            if (('1'-ch)==curr)
                cnt2++;
            curr=1-curr;
        }

        return Math.min(cnt1,cnt2);
    }
}