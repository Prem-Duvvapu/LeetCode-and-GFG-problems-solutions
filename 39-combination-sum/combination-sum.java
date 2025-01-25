class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        getCombination(0,candidates,target,res,0,new ArrayList<>());
        return res;
    }

    private void getCombination(int pos,int[] candidates,int target,List<List<Integer>> res,int currSum, List<Integer> currList) {

        if (currSum > target || pos==candidates.length) {
            return;
        }

        if (currSum==target) {
            res.add(new ArrayList<>(currList));
            return;
        }

        //pick and stay
        currSum+=candidates[pos];
        currList.add(candidates[pos]);
        getCombination(pos,candidates,target,res,currSum,currList);
        currSum-=candidates[pos];
        currList.remove(currList.size()-1);

        //not pick
        getCombination(pos+1,candidates,target,res,currSum,currList);
    }
}