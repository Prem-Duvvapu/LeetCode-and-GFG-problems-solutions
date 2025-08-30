class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        solve(0,currList,res,nums);
        return res;
    }

    private void solve(int pos,List<Integer> currList,List<List<Integer>> res,int[] nums) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }

        // not pick
        solve(pos+1, currList, res, nums);

        // pick
        currList.add(nums[pos]);
        solve(pos+1, currList, res, nums);
        currList.remove(currList.size() - 1);
    }
}
