class Solution {
    public int buyChoco(int[] prices, int money) {
        int n=prices.length;
        int min1=101,min2=101;

        for (int i=0;i<n;i++) {
            if (prices[i]<min1) {
                min2=min1;
                min1=prices[i];
            }
            else if (prices[i]<min2)
                min2=prices[i];
        }

        int rem=money-(min1+min2);
        if (rem<0)
            return money;
        return rem;
    }
}