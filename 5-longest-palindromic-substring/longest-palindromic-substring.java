//Recursion
class Solution {
    private boolean isPalindrome(String s,int left,int right)
    {
        if (left>=right)
            return true;

        if (s.charAt(left)==s.charAt(right))
            return isPalindrome(s,left+1,right-1);

        return false;
    }

    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0;
        int end=0;

        for (int i=0;i<n;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (isPalindrome(s,j,i) && (i-j+1)>(end-start+1))
                {
                    start=j;
                    end=i;
                }
            }
        }

        return s.substring(start,end+1);
    }
}