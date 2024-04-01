class Solution {
    public int lengthOfLastWord(String s) {
        int res=0;
        int n=s.length();
        boolean flag1=false;

        for (int i=n-1;i>=0;i--) {
            if (s.charAt(i)==' ') {
                if (flag1)
                    break;
                continue;
            }

            flag1=true;
            res++;
        }

        return res;
    }
}