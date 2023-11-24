class Solution {
    public int maxCoins(int[] piles) {
        int n=piles.length;
        Arrays.sort(piles);
        int res=0;

        for (int cnt=0,i=n-2;cnt<n/3;cnt++,i-=2)
            res+=piles[i];

        return res;
    }
}