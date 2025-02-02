//using binary search
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> l=new ArrayList<>();
        l.add(nums[0]);

        for (int i=1;i<n;i++) {
            if (nums[i]>l.get(l.size()-1)) {
                l.add(nums[i]);
            } else {
                int index=lowerBound(l,nums[i]);
                l.set(index,nums[i]);
            }
        }

        return l.size();
    }

    private int lowerBound(List<Integer> list,int value) {
        int left=0;
        int right=list.size()-1;
        int ans=0;

        while (left<=right) {
            int mid=left+(right-left)/2;
            if (value<=list.get(mid)) {
                ans=mid;
                right=mid-1;
            } else {
                left=mid+1;
            }
        }

        return ans;
    }
}