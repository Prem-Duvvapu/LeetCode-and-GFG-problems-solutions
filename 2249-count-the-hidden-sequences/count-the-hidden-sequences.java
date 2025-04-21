class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n=differences.length;
        int cnt=0;
        int[] currInterval={lower,upper};
        int res=0;

        for (int i=0;i<n;i++) {
            currInterval[0]-=differences[i];
            currInterval[1]-=differences[i];

            currInterval[0]=Math.max(currInterval[0],lower);
            currInterval[1]=Math.min(currInterval[1],upper);

            if (currInterval[0]>currInterval[1])
                return 0;
        }
        
        res=(currInterval[1]-currInterval[0]+1);
        return res;
    }
}