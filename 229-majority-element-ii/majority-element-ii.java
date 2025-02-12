//optimal
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        int mE1=0;
        int mE1Cnt=0;
        int mE2=0;
        int mE2Cnt=0;

        for (int i=0;i<n;i++) {
            if (mE1Cnt==0 && nums[i]!=mE2) {
                mE1=nums[i];
                mE1Cnt++;
            } else if (mE2Cnt==0 && nums[i]!=mE1) {
                mE2=nums[i];
                mE2Cnt++;
            } else if (nums[i]==mE1) {
                mE1Cnt++;
            } else if (nums[i]==mE2) {
                mE2Cnt++;
            } else {
                mE1Cnt--;
                mE2Cnt--;
            }
        }

        mE1Cnt=mE2Cnt=0;
        for (int i=0;i<n;i++) {
            if (nums[i]==mE1)
                mE1Cnt++;
            else if (nums[i]==mE2)
                mE2Cnt++;
        }

        if (mE1Cnt > n/3)
            res.add(mE1);

        if (mE2Cnt > n/3)
            res.add(mE2);

        return res;
    }
}