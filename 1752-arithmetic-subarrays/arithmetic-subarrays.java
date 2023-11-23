//Brute Force
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n=nums.length;
        int m=l.length;
        List<Boolean> res=new ArrayList<>();

        for (int i=0;i<m;i++)
        {
            List<Integer> curr=new ArrayList<>();
            for (int j=l[i];j<=r[i];j++)
                curr.add(nums[j]);
            Collections.sort(curr);
            int diff=curr.get(1)-curr.get(0);
            int k=1;
            for (;k<curr.size();k++)
            {
                if (curr.get(k)-curr.get(k-1)!=diff)
                {
                    res.add(false);
                    break;
                }
            }
            if (k==curr.size())
                res.add(true);
        }

        return res;

    }
}