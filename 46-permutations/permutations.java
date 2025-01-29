class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        solve(0,nums,res,new ArrayList<>());
        return res;
    }

    private void solve(int pos,int[] nums,List<List<Integer>> res,List<Integer> currList) {
        if (pos==nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }
        
        for (int i=pos;i<nums.length;i++) {
            swap(nums,pos,i);
            currList.add(nums[pos]);
            solve(pos+1,nums,res,currList);
            currList.remove(currList.size()-1);
            swap(nums,pos,i);
        }
    }

    private void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}