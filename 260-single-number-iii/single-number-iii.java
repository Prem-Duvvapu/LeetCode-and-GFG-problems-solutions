class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res=new int[2];

        int diff=0;
        for (int val: nums)
            diff^=val;

        //2's complement
        diff&=(~diff+1);//to find right most set bit

        for (int val: nums)
        {
            if ((val&diff)>0)
                res[0]^=val;
            else
                res[1]^=val;
        }

        return res;
    }
}