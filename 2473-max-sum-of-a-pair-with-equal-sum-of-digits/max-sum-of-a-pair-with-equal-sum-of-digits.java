//better
class Solution {
    public int maximumSum(int[] nums) {
        int n=nums.length;
        int maxSum=-1;
        Map<Integer,Integer> map=new HashMap<>();
       
        for (int i=0;i<n;i++) {
            int currNumDigitsSum=sumOfDigits(nums[i]);

            if (map.containsKey(currNumDigitsSum)) {
                int prevNumIndex=map.get(currNumDigitsSum);
                int currSum=nums[prevNumIndex]+nums[i];
                maxSum=Math.max(maxSum,currSum);

                if (nums[i]>nums[prevNumIndex])
                    map.put(currNumDigitsSum,i);
            } else {
                map.put(currNumDigitsSum,i);
            }
        }

        return maxSum;
    }

    public int sumOfDigits(int n) {
        int sum=0;

        while (n>0) {
            sum+=(n%10);
            n/=10;
        }

        return sum;
    }
}