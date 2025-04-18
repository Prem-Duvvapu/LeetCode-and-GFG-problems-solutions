class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,res,new ArrayList<>());
        return res;   
    }

    private void solve(int pos,int[] nums,List<List<Integer>> res,List<Integer> currList) {
        res.add(new ArrayList<>(currList));

        for (int i=pos;i<nums.length;i++) {
            if (i>pos && nums[i]==nums[i-1])
                continue;

            currList.add(nums[i]);
            solve(i+1,nums,res,currList);
            currList.remove(currList.size()-1);
        }
    }
}