class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>[] dp=new HashMap[n];
        int total=0;

        for (int i=0;i<n;i++)
            dp[i]=new HashMap<>();

        for (int i=1;i<n;i++) {
            for (int j=0;j<i;j++) {
                long temp=(long)nums[i]-(long)nums[j];
                if (temp<Integer.MIN_VALUE || temp>Integer.MAX_VALUE)
                    continue;

                int diff=(int)temp;

                dp[i].put(diff,dp[i].getOrDefault(diff,0)+1);
                if (dp[j].containsKey(diff)) {
                    total+=dp[j].get(diff);
                    dp[i].put(diff,dp[i].get(diff)+dp[j].get(diff));
                }
            }
        }

        return total;
    }
}