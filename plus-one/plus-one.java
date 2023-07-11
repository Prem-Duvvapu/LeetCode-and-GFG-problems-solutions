class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int[] a=new int[n];
        for (int i=0;i<n;i++)
            a[i]=digits[i];

        for (int i=n-1;i>=0;i--)
        {
            if (a[i]<9)
            {
                a[i]++;
                return a;
            }

            a[i]=0;
        }

        int[] res=new int[n+1];
        res[0]=1;
        return res;
    }
}