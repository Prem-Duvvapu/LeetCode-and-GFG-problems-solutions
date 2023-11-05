class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        
        int cnt1=0;
        int cnt2=0;
        
        long sum1=0;
        long sum2=0;
        
        for (int val: nums1)
        {
            if (val==0)
                cnt1++;
            sum1+=val;
        }
        
        for (int val: nums2)
        {
            if (val==0)
                cnt2++;
            sum2+=val;
        }
        
        
        if (cnt1==0 && cnt2==0)
        {
            if (sum1!=sum2)
                    return -1;
        }
        else if (cnt2==0)
        {
            if (sum2-sum1<cnt1)   
                    return -1;
        }
        else if (cnt1==0)
        {
            if (sum1-sum2<cnt2)
                    return -1;
        }
        
        sum1+=cnt1;
        sum2+=cnt2;
        return Math.max(sum1,sum2);
    }
}