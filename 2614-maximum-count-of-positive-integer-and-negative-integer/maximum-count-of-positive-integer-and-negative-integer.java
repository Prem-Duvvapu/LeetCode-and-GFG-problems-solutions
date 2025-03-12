class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int lb=lowerBound(nums,0);
        int ub=upperBound(nums,0);
        System.out.println(lb+" "+ub);
        int negativeCnt=lb;
        int positiveCnt=n-ub;

        return Math.max(negativeCnt,positiveCnt);
    }

    public int lowerBound(int[] nums,int findVal) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int lowerBoundIndex=n;

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (nums[mid]>=findVal) {
                lowerBoundIndex=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return lowerBoundIndex;
    }

    public int upperBound(int[] nums,int findVal) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int upperBoundIndex=n;

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (nums[mid]>findVal) {
                upperBoundIndex=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return upperBoundIndex;
    }
}

/*
findVal=0
index=6
nums = [-2, -1, -1, 0, 0, 0, 1, 2, 3]
        0.   1.  2. 3. 4. 5. 6. 7. 8


lowerBound=3
upperBound=6;

nums = [-2, -1, -1, 0, 1, 2, 3]

nums = [-2,-1,-1,1,2,3]


searchValue=0

lowerBound - smallest Index which has value greater than or equal to SearchValue

upperBound- smallest Index which has value greater than SearchValue
*/