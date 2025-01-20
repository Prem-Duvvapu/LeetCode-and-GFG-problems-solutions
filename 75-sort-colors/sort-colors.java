class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int zeroesCount=0;
        int onesCount=0;
        int twosCount=0;
        int index=0;

        for (int i=0;i<n;i++) {
            if (nums[i]==0)
                zeroesCount++;
            else if (nums[i]==1)
                onesCount++;
            else
                twosCount++;
        }

        while (zeroesCount-- > 0)
            nums[index++]=0;

        while (onesCount-- > 0)
            nums[index++]=1;

        while (twosCount-- > 0)
            nums[index++]=2;
    }
}