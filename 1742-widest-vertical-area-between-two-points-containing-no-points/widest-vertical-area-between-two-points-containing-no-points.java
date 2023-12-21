class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n=points.length;
        Comparator<int[]> com=new Comparator<>() {
            public int compare(int[] a,int[] b) {
                if (a[0]>b[0])
                    return 1;
                else
                    return -1;
            }
        };

        Arrays.sort(points,com);
        int maxWidth=0;
        for (int i=1;i<n;i++)
            maxWidth=Math.max(maxWidth,points[i][0]-points[i-1][0]);

        return maxWidth;
    }
}