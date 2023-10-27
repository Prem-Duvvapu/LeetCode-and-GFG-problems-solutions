class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String res="";

        for (int i=0;i<n;i++)
        {
            int left=i;
            int right=i;

            while (left>=0 && s.charAt(left)==s.charAt(i))
                left--;

            while (right<n && s.charAt(right)==s.charAt(i))
                right++;

            while (left>=0 && right<n)
            {
                if (s.charAt(left)!=s.charAt(right))
                    break;

                left--;
                right++;
            }

            if (right-left-1>res.length())
                res=s.substring(left+1,right);
        }

        return res;
    }
}