class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        int[][] arr=new int[n][2];
        int res=0;

        for (int i=0;i<n;i++)
        {
            arr[i][0]=dist[i];
            arr[i][1]=speed[i];
        }

        Comparator<int[]> com=new Comparator<>()
        {
            public int compare(int[] a,int[] b)
            {
                double x=(double)a[1]/a[0];
                double y=(double)b[1]/b[0];

                if (x<y)
                    return 1;
                else
                    return -1;
            }
        };

        Arrays.sort(arr,com);
        for (int i=0;i<n;i++)
        {
            arr[i][0]=arr[i][0]-arr[i][1]*i;
            if (arr[i][0]>0)
                res++;
            else
                break;
        }

        return res;
    }
}