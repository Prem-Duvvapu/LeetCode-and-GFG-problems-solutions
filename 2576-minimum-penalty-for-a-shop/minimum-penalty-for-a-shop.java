class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int maxSum=-1*n;
        int currSum=0;
        int ans=0;
        int i=0;

        for (i=0;i<n;i++)
        {
            if (currSum>maxSum)
            {
                ans=i;
                maxSum=currSum;
            }

            if (customers.charAt(i)=='Y')
                currSum++;
            else
                currSum--;
        }

        if (currSum>maxSum)
        {
            ans=i;
            maxSum=currSum;
        }

        return ans;
    }
}