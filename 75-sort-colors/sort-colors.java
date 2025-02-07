//Better
//T.C.: O(2*n)
//S.C.: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int[] cnt=new int[3];

        for (int i=0;i<n;i++)
            cnt[nums[i]]++;

        int pos=0;
        
        while (cnt[0]-- > 0)
            nums[pos++]=0;

        while (cnt[1]-- > 0)
            nums[pos++]=1;

        while (cnt[2]-- > 0)
            nums[pos++]=2;
    }
}