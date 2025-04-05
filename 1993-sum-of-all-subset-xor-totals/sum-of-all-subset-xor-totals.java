class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        int[] res={0};

        solve(0,0,res,nums,n);

        return res[0];
    }

    public void solve(int pos,int currXor,int[] res,int[] nums,int n) {
        if (pos==n) {
            System.out.println(currXor);
            res[0]+=currXor;
            return;
        }

        //pick
        solve(pos+1,currXor^nums[pos],res,nums,n);

        //not pick
        solve(pos+1,currXor,res,nums,n);
    }
}