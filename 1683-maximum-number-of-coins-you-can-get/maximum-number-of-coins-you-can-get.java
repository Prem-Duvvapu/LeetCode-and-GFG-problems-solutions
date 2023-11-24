class Solution {
    public int maxCoins(int[] piles) {
        int n=piles.length;
        Arrays.sort(piles);
        int i=n-2;
        int res=0;

        for (int cnt=0;cnt<n/3;cnt++)
        {
            res+=piles[i];
            i-=2;
        }
        
        return res;
    }
}