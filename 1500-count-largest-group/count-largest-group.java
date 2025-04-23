class Solution {
    public int countLargestGroup(int n) {
        //we will get maxSum when num=9999, sum=9+9+9+9=36
        int[] groupSize=new int[37];
        int maxGroupSize=0;
        int groupsCnt=0;

        for (int num=1;num<=n;num++) {
            int digitsSum=sumOfDigits(num);
            groupSize[digitsSum]++;
        }

        // System.out.println(Arrays.toString(groupSize));

        for (int sum=1;sum<groupSize.length;sum++) {
            if (groupSize[sum]>maxGroupSize) {
                maxGroupSize=groupSize[sum];
                groupsCnt=1;
            } else if (groupSize[sum]==maxGroupSize) {
                groupsCnt++;
            }
        }

        return groupsCnt;
    }

    public int sumOfDigits(int num) {
        int temp=num;
        int totalSum=0;

        while (temp>0) {
            int lastDigit=temp%10;
            totalSum+=lastDigit;
            temp/=10;
        }

        return totalSum;
    }
}