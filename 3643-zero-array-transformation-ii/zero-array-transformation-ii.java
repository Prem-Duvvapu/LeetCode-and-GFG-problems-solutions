class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int res=-1;

        int[] diff=new int[nums.length];
        if (checkAllZeroes(nums,diff,nums.length))
            return 0;

        int low=0;
        int high=queries.length-1;

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (solve(nums,queries,mid)) {
                res=mid+1;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return res;
    }

    public boolean solve(int[] nums,int[][] queries,int k) {
        int n=nums.length;
        int[] diffArr=new int[n];

        for (int q=0;q<=k;q++) {
            int first=queries[q][0];
            int last=queries[q][1];
            int val=queries[q][2];

            diffArr[first]+=val;
            if (last+1<n)
                diffArr[last+1]-=val;
        }

        for (int i=1;i<n;i++)
            diffArr[i]+=diffArr[i-1];

        // System.out.println("k"+k);
        // System.out.println("nums"+Arrays.toString(nums));
        // System.out.println("diff"+Arrays.toString(diffArr));
        // System.out.println();

        return (checkAllZeroes(nums,diffArr,n));        
    }

    public boolean checkAllZeroes(int[] nums,int[] diff,int n) {
        for (int i=0;i<n;i++)
            if (nums[i]-diff[i]>0)
                return false;

        return true;
    }
}