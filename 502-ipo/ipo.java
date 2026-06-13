class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int maxCapital = w;
        int[][] capitalAndProfit = new int[n][2];

        for (int i=0;i<n;i++) {
            capitalAndProfit[i][0] = capital[i];
            capitalAndProfit[i][1] = profits[i];
        }

        Arrays.sort(capitalAndProfit, (a,b) -> Integer.compare(a[0], b[0]));
        int pickedProjectsCnt = 0;
        int currProjectPos = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (pickedProjectsCnt < k) {
            while (currProjectPos < n && capitalAndProfit[currProjectPos][0] <= maxCapital) {
                maxHeap.add(capitalAndProfit[currProjectPos][1]);
                currProjectPos++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            maxCapital += maxHeap.poll();
            pickedProjectsCnt++;
        }

        return maxCapital;
    }
}