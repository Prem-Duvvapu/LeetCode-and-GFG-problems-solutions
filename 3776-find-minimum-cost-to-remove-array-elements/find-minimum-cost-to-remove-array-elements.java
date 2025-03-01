class Solution {
    public int func(int idx,int preIdx,int[] nums,int[][] dp){
        if(idx>=nums.length){
            if(preIdx<nums.length) return nums[preIdx];
            return 0;
        }
        if(idx==nums.length-1) return Math.max(nums[preIdx],nums[nums.length-1]);
        if(idx>=nums.length-2){
            int a=Math.max(nums[preIdx],nums[nums.length-1])+nums[nums.length-2];
            int b=Math.max(nums[preIdx],nums[nums.length-2])+nums[nums.length-1];
            int c=Math.max(nums[nums.length-2],nums[nums.length-1])+nums[preIdx];
            
             return Math.min(a,Math.min(b,c));
        }

        if(dp[preIdx][idx]!=-1) return dp[preIdx][idx];
        int ans=Integer.MAX_VALUE;
        int n1=0;
        int n2=0;
        int n3=0;
        if(idx+1<nums.length) n1=Math.max(nums[preIdx],nums[idx+1])+func(idx+2,idx,nums,dp);
        if(idx<nums.length) n2=Math.max(nums[preIdx],nums[idx])+func(idx+2,idx+1,nums,dp);
        if(idx+1<nums.length) n3=Math.max(nums[idx],nums[idx+1])+func(idx+2,preIdx,nums,dp);
        if(n1!=0) ans=Math.min(ans,n1);
        if(n2!=0) ans=Math.min(ans,n2);
        if(n3!=0) ans=Math.min(ans,n3);
        return dp[preIdx][idx]=ans;
    }

    public int minCost(int[] nums) {
        int[][] dp=new int[1001][1001];
        if (nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        for(int[]p : dp) Arrays.fill(p,-1);
        int y1=Math.max(nums[0],nums[1])+func(3,2,nums,dp);
        int y2=Math.max(nums[1],nums[2])+func(3,0,nums,dp);
        int y3=Math.max(nums[2],nums[0])+func(3,1,nums,dp);
        return Math.min(y1,Math.min(y2,y3));
    }
}