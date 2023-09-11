class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),nums,res);
        return res;
    }

    private void solve(int pos,List<Integer> currList,int[] nums,List<List<Integer>> res)
    {
        if (currList.size()==nums.length)
        {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=pos;i<nums.length;i++)
        {
            swap(nums,pos,i);
            currList.add(nums[pos]);
            solve(pos+1,currList,nums,res);
            currList.remove(currList.size()-1);
            swap(nums,pos,i);
        }
    }

    private void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}