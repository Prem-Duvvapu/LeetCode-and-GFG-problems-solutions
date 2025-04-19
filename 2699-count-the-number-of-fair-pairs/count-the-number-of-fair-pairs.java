class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length;
        long res=0;
        Arrays.sort(nums);

        for (int i=0;i<n-1;i++) {
            int minPossibleJ=-1;
            int maxPossibleJ=-1;

            int low=i+1;
            int high=n-1;

            while (low<=high) {
                int mid=low+(high-low)/2;

                if (lower<=nums[i]+nums[mid] && nums[i]+nums[mid]<=upper) {
                    minPossibleJ=mid;
                    high=mid-1;
                } else if (lower>nums[i]+nums[mid]) {
                    low=mid+1;
                } else {
                    high=mid-1;
                }
            }

            if (minPossibleJ==-1)
                continue;

            low=minPossibleJ;
            high=n-1;
            while (low<=high) {
                int mid=low+(high-low)/2;

                if (lower<=nums[i]+nums[mid] && nums[i]+nums[mid]<=upper) {
                    maxPossibleJ=mid;
                    low=mid+1;
                } else if (lower>nums[i]+nums[mid]) {
                    low=mid+1;
                } else {
                    high=mid-1;
                }
            }

            res+=(maxPossibleJ-minPossibleJ+1);
        }

        return res;
    }
}