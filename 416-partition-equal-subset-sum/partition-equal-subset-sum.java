//DP on subsequences
//Space Optimization

class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for (int val: nums)
            sum+=val;

        if (sum%2==1)//odd
            return false;

        //subset sum equal to target problem from here
        int target=sum/2;
        boolean[] prev=new boolean[target+1];
        boolean[] curr=new boolean[target+1];

        prev[0]=true;
        curr[0]=true;

        if (nums[0]<=target)
            prev[nums[0]]=true;

        for (int i=1;i<n;i++)
        {
            for (int j=1;j<=target;j++)
            {
                boolean notTake=prev[j];
                boolean take=false;
                if (nums[i]<=j)
                    take=prev[j-nums[i]];

                curr[j]=(take || notTake);
            }

            for (int k=0;k<=target;k++)
                prev[k]=curr[k];
        }

        return prev[target];
    }
}