class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        
        for (int l=1;l<=n/2;l++)
        {
            if (n%l==0)
            {
                int times=n/l;
                String sub=s.substring(0,l);
                String curr="";

                while (times-- > 0)
                    curr+=sub;

                if (curr.equals(s))
                    return true;
            }
        }

        return false;
    }
}