class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int mod=(int)1e9+7;
        int evenCnt=1;
        int oddCnt=0;
        int currSum=0;
        int res=0;

        for (int i=0;i<n;i++) {
            currSum+=arr[i];

            if (currSum%2==1) {
                res=(res+evenCnt)%mod;
            } else {
                res=(res+oddCnt)%mod;
            }

            if (currSum%2==1)
                oddCnt++;
            else
                evenCnt++;
        }

        return res;
    }
}