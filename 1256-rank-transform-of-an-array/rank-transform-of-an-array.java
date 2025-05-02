class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[][] sortedArr=new int[n][2];
        int[] res=new int[n];

        if (n==0)
            return res;

        for (int i=0;i<n;i++) {
            sortedArr[i][0]=arr[i];
            sortedArr[i][1]=i;
        }

        Arrays.sort(sortedArr, (x,y) -> Integer.compare(x[0],y[0]));

        int rank=1;
        res[sortedArr[0][1]]=rank;

        for (int i=1;i<n;i++) {
            if (sortedArr[i][0]==sortedArr[i-1][0])
                res[sortedArr[i][1]]=rank;
            else
                res[sortedArr[i][1]]=++rank;
        }

        return res;
    }
}