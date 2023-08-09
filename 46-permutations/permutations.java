class Solution {
    private void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private void solve(int pos,int[] nums,List<List<Integer>> res)
    {
        if (pos==nums.length)
        {
            List<Integer> l=new ArrayList<>();
            for (int val: nums)
                l.add(val);
            res.add(l);
            return;
        }

        for (int i=pos;i<nums.length;i++)
        {
            swap(nums,pos,i);
            solve(pos+1,nums,res);
            swap(nums,pos,i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(0,nums,res);
        return res;
    }
}