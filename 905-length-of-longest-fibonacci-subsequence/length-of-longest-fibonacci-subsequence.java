class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        Map<Integer,Integer> map=new HashMap<>();
        int maxLen=0;

        for (int[] a: dp)
            Arrays.fill(a,2);

        for (int i=0;i<n;i++)
            map.put(arr[i],i);

        for (int i=2;i<n;i++) {
            for (int j=1;j<i;j++) {
                int prevVal=arr[i]-arr[j];
                if (map.containsKey(prevVal) && map.get(prevVal)<j) {
                    dp[i][j]=1+dp[j][map.get(prevVal)];
                    maxLen=Math.max(maxLen,dp[i][j]);
                }
            }
        }

        return maxLen;
    }
}