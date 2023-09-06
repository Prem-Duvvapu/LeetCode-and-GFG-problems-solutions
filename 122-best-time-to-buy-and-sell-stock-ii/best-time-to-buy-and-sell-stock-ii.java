//Space Optimization

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] next=new int[2];
        int[] curr=new int[2];
        
        for (int i=n-1;i>=0;i--)
        {
            for (int j=0;j<=1;j++)
            {
                if (j==1)
                {
                    int buy=-prices[i];
                    int notBuy=0;
                    if (i<n-1)
                    {
                        buy+=next[0];
                        notBuy=next[1];
                    }
                    curr[j]=Math.max(buy,notBuy);
                }
                else
                {
                    int sell=prices[i];
                    int notSell=0;
                    if (i<n-1)
                    {
                        sell+=next[1];
                        notSell=next[0];
                    }
                    curr[j]=Math.max(sell,notSell);
                }
            }

            next[0]=curr[0];
            next[1]=curr[1];
        }

        return next[1];
    }
}