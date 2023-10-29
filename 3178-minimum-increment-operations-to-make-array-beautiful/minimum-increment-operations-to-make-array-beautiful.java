//Memoization
class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n=nums.length;
        long[] dp=new long[n];
        
        for (int i=0;i<n;i++)
                dp[i]=-1;
        
        long ans=solve(0,nums,k,dp);
        return ans;
    }
    
    private long solve(int pos,int[] nums,int k,long[] dp)
    {
        if (pos>nums.length-3)
            return 0;
        
        if (dp[pos]!=-1)
            return dp[pos];
        
        long a=Math.max(0,k-nums[pos])+solve(pos+1,nums,k,dp);
        long b=Math.max(0,k-nums[pos+1])+solve(pos+2,nums,k,dp);
        long c=Math.max(0,k-nums[pos+2])+solve(pos+3,nums,k,dp);
        
        return dp[pos]=Math.min(a,Math.min(b,c));  
    }
}

// for (int i=0;i<=n-3;i++)
//         {
//             int mx=nums[i];
//             int index=i;
//             for (int j=i;j<i+3;j++)
//             {
//                 if (nums[j]>=mx)
//                 {
//                     mx=nums[j];
//                     index=j;
//                 }
//             }
            
//             if (mx<k)
//             {
//                 ans+=(k-mx);
//                 nums[index]=k;
//             }
//         }
        
//         return ans;