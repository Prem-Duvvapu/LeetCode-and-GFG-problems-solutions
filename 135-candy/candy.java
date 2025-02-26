//Time: O(2*n)
//Space: O(n)

class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        if (n==1)
            return 1;

        int[] left=new int[n];
        int right=1;
        int res=0;

        left[0]=1;

        for (int i=1;i<n;i++) {
            if (ratings[i]>ratings[i-1])
                left[i]=1+left[i-1];
            else
                left[i]=1;
        }

        res+=Math.max(left[n-1],right);
        for (int i=n-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1])
                right++;
            else
                right=1;
            res+=Math.max(left[i],right);
        }

        return res;
    }
}