//Time: O(3*n)
//Space: O(2*n)

class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        if (n==1)
            return 1;

        int[] prefix=new int[n];
        int[] suffix=new int[n];
        int res=0;

        prefix[0]=1;
        suffix[n-1]=1;

        for (int i=1;i<n;i++) {
            if (ratings[i]>ratings[i-1])
                prefix[i]=1+prefix[i-1];
            else
                prefix[i]=1;
        }

        for (int i=n-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1])
                suffix[i]=1+suffix[i+1];
            else
                suffix[i]=1;
        }

        for (int i=0;i<n;i++)
            res+=Math.max(prefix[i],suffix[i]);

        return res;
    }
}