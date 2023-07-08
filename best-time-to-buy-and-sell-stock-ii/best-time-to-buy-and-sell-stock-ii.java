class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int minVal=prices[0];

        for (int val: prices)
        {
            if (val-minVal>0)
                res+=(val-minVal);

            minVal=val;
        }

        return res;
    }
}