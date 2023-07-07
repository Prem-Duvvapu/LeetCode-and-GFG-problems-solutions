class Solution {
    private int binSearch(List<Integer> list,int val)
    {
        int left=0;
        int right=list.size()-1;
        
        while (left<=right)
        {
            int mid=left+(right-left)/2;

            if (val==list.get(mid))
                return mid;
            else if (val<list.get(mid))
                right=mid-1;
            else
                left=mid+1;
        }

        return right+1;
    }

    public int lengthOfLIS(int[] nums) {
        int res=1;
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);

        for (int i=1;i<nums.length;i++)
        {
            if (nums[i]>list.get(res-1))
            {
                list.add(nums[i]);
                res++;
            }
            else
            {
                int index=binSearch(list,nums[i]);
                list.set(index,nums[i]);
            }
        }

        return res;
    }
}