class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int res=0;
        for (int i=0;i<n;i++)
            for (int j=i;j<n;j++)
                if (isPalindrome(i,j,s))
                    res++;

        return res;
    }

    private boolean isPalindrome(int left,int right,String s) {
        while (left<right) {
            if (s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}