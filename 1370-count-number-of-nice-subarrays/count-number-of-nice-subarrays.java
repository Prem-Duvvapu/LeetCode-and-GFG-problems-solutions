class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[n];

        for (int i=0;i<n;i++)
            arr[i]=nums[i]%2;

        int res=solve(arr,k)-solve(arr,k-1);
        return res;
    }

    private int solve(int[] nums,int k) {
        int left=0;
        int right=0;
        int resCnt=0;
        int sum=0;

        while (right < nums.length) {
            sum+=nums[right];

            while (sum > k) {
                sum-=nums[left];
                left++;
            }

            resCnt+=(right-left+1);
            right++;
        }

        return resCnt;
    }
}