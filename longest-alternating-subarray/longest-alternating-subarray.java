class Solution {
    private boolean helper(int[] a,int left,int right)
    {
        int val=a[left];
        int cnt=1;
        
        for (int i=left+1;i<=right;i++)
        {
            if (cnt%2==1)
            {
                if (a[i]!=val+1)
                    return false;
            }
            else
            {
                if (a[i]!=val)
                    return false;
            }
            cnt++;
        }
        
        return true;
    }
    
    public int alternatingSubarray(int[] nums) {
        int res=-1;
        int n=nums.length;
        
        for (int i=0;i<n;i++)
        {
            for (int j=i+1;j<n;j++)
            {
                if (helper(nums,i,j))
                {
                    res=Math.max(j-i+1,res);
                }
                else
                {
                    break;
                }
            }
        }
        
        return res;
    }
}