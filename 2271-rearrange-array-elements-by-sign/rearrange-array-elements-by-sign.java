class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int pos=0;

        for (int i=0;i<n;i++) {
            if (nums[i]>0) {
                res[pos]=nums[i];
                pos+=2;
            }
        }

        pos=1;
        for (int i=0;i<n;i++) {
            if (nums[i]<0) {
                res[pos]=nums[i];
                pos+=2;
            }
        }

        return res;
    }
}