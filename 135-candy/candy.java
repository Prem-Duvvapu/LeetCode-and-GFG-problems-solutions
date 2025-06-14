class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        int minCandies=0;

        prefix[0]=suffix[n-1]=1;

        //left to right
        for (int i=1;i<n;i++) {
            if (ratings[i]>ratings[i-1])
                prefix[i]=1+prefix[i-1];
            else
                prefix[i]=1;
        }

        //right to left
        for (int i=n-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1])
                suffix[i]=1+suffix[i+1];
            else
                suffix[i]=1;
        }

        for (int i=0;i<n;i++)
            minCandies+=Math.max(prefix[i],suffix[i]);

        return minCandies;
    }
}