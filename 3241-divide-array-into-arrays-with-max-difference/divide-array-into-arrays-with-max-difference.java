class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int[][] res=new int[n/3][3];

        Arrays.sort(nums);

        for (int i=0;i<n;i+=3) {
            for (int j=i;j<i+3;j++) {
                if (j==i)
                    res[i/3][j%3]=nums[j];
                else {
                    if (nums[j]-nums[i]>k)
                        return new int[0][0];
                    else
                        res[i/3][j%3]=nums[j];
                }
            }
        }

        return res;
    }
}