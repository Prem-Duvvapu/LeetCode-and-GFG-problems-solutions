class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0,target,new ArrayList<>(),res,candidates);
        return res;
    }

    private void solve(int pos,int target,List<Integer> currList,List<List<Integer>> res,int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(currList));
            return;
        }

        if (pos >= candidates.length) {
            return;
        }

        // not pick
        solve(pos+1,target,currList,res,candidates);

        // pick and stay
        if (candidates[pos] <= target) {
            currList.add(candidates[pos]);
            solve(pos,target-candidates[pos],currList,res,candidates);
            currList.remove(currList.size()-1);
        }
    }
}