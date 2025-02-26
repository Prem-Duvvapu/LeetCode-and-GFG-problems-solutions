//Time: O(3*n)
//Space: O(2*n)

class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        if (n==1)
            return 1;

        int[] left=new int[n];
        int[] right=new int[n];
        int res=0;

        left[0]=1;
        right[n-1]=1;

        for (int i=1;i<n;i++) {
            if (ratings[i]>ratings[i-1])
                left[i]=1+left[i-1];
            else
                left[i]=1;
        }

        for (int i=n-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1])
                right[i]=1+right[i+1];
            else
                right[i]=1;
        }

        for (int i=0;i<n;i++)
            res+=Math.max(left[i],right[i]);

        return res;
    }
}