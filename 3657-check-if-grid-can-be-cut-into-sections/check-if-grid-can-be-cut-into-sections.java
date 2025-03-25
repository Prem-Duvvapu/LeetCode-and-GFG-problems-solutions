class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int m=rectangles.length;

        int[][] xArr=new int[m][2];
        int[][] yArr=new int[m][2];

        for (int i=0;i<m;i++) {
            xArr[i][0]=rectangles[i][0];
            xArr[i][1]=rectangles[i][2];

            yArr[i][0]=rectangles[i][1];
            yArr[i][1]=rectangles[i][3];
        }

        return (mergeIntervals(xArr) || mergeIntervals(yArr));
    }

    public boolean mergeIntervals(int[][] intervals) {
        int n=intervals.length;
        List<int[]> arr=new ArrayList<>();

        Comparator<int[]> com=new Comparator<>() {
            public int compare(int[] a,int[] b) {
                if (a[0]<b[0])
                    return -1;
                else if (a[0]>b[0])
                    return 1;

                return 0;
            }
        };

        Arrays.sort(intervals,com);

        int start=intervals[0][0];
        int end=intervals[0][1];
        
        for (int i=1;i<n;i++) {
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];

            if (currStart<end) {
                end=Math.max(end,currEnd);
            } else {
                arr.add(new int[]{start,end});
                start=currStart;
                end=currEnd;
            }
        }

        arr.add(new int[]{start,end});

        System.out.println();

        return arr.size()>=3;
    }
}