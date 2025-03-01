class Solution {
    public boolean func(int[]piles,int h,int a){
        int hrs=0;
        for(int i=0;i<piles.length;i++){
            int val=(int)Math.ceil((double)piles[i]/a);
            if ((long)hrs+(long)val>(long)h)
                return false;
            hrs+=val;
        }

        return hrs<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=piles[0];
        
        for(int i=0;i<piles.length;i++){
            high=Math.max(piles[i],high);
        }

        int ans=high;

        while(low<=high){
            int mid=low+((high-low)/2);
            if(func(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}