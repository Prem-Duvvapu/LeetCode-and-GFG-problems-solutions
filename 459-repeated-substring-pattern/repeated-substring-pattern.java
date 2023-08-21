//slightly optimized

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();

        for (int l=n/2;l>=1;l--)
        {
            if (n%l==0)//O(2*sqrt(n))
            {
                int times=n/l;
                String sub=s.substring(0,l);//O(n)
                StringBuilder curr=new StringBuilder();

                while (times-- > 0)//O(n)
                    curr.append(sub);

                if (curr.toString().equals(s))//O(n)
                    return true;
            }
        }

        return false;
    }
}

/*
Maximum no. of factors for a number 'n'=2*sqrt(n)
T.C:- O(n*sqrt(n))
*/