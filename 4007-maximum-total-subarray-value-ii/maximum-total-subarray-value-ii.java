class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        SparseTable sparseTable = new SparseTable(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        for (int i = 0; i < n; i++) {
            pq.add(new int[] {sparseTable.query(i,n), i, n});
        }

        int cnt = 0;
        while (pq.peek()[0] > 0 && cnt < k) {
            int[] topEle = pq.poll();
            res += topEle[0];
            topEle[2]--;
            topEle[0] = sparseTable.query(topEle[1],topEle[2]);
            pq.add(topEle);
            cnt++;
        }

        return res;
    }
}


class SparseTable {
    private final int[][] minArr;
    private final int[][] maxArr;

    public SparseTable(int[] arr) {
        int n = arr.length;
        int bitWidth = 32 - Integer.numberOfLeadingZeros(n);
        minArr = new int[bitWidth][n];
        maxArr = new int[bitWidth][n];

        for (int i = 0;i < n; i++) {
            minArr[0][i] = arr[i];
            maxArr[0][i] = arr[i];
        }

        for (int i = 1; i < bitWidth; i++) {
            for (int j = 0; j + (1 << i) <= n; j++) {
                minArr[i][j] = Math.min(minArr[i-1][j], minArr[i-1][j + (1 << (i - 1))]);
                maxArr[i][j] = Math.max(maxArr[i-1][j], maxArr[i-1][j + (1 << (i - 1))]);
            }
        }
    }

    public int query(int left, int right) {
        int k = 31 - Integer.numberOfLeadingZeros(right - left);
        int maxVal = Math.max(maxArr[k][left], maxArr[k][right - (1 << k)]);
        int minVal = Math.min(minArr[k][left], minArr[k][right - (1 << k)]);
        return (maxVal - minVal);
    }
}