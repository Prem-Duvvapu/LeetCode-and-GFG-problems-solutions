class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int[][] a=new int[n][2];

        for (int i=0;i<n;i++)
        {
            a[i][0]=nums[i];
            a[i][1]=i;
        }

        Arrays.sort(a,(x,y)->(x[0]-y[0]));
        int[] prefix=new int[n];
        int[] suffix=new int[n];

        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];

        for (int i=1;i<n;i++)
            prefix[i]=a[i][0]+prefix[i-1];

        for (int i=n-2;i>=0;i--)
            suffix[i]=a[i][0]+suffix[i+1];

        a[0][0]=suffix[1]-(a[0][0]*(n-1));
        a[n-1][0]=a[n-1][0]*(n-1)-prefix[n-2];
        for (int i=1;i<n-1;i++)
            a[i][0]=(a[i][0]*i-prefix[i-1])+(suffix[i+1]-(a[i][0]*(n-1-i)));
        
        Arrays.sort(a,(x,y)->(x[1]-y[1]));
        int[] res=new int[n];
        for (int i=0;i<n;i++)
            res[i]=a[i][0];

        return res;
    }
}