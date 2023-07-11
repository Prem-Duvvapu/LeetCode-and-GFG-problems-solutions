class Solution {
    public void sortColors(int[] nums) {
        int zeroCnt=0;
        int oneCnt=0;
        int twoCnt=0;

        for (int val: nums)
        {
            if (val==0)
                zeroCnt++;
            else if (val==1)
                oneCnt++;
            else
                twoCnt++;
        }

        int i=0;
        while (zeroCnt-- > 0)
            nums[i++]=0;

        while (oneCnt-- > 0)
            nums[i++]=1;

        while (twoCnt-- > 0)
            nums[i++]=2;
    }
}