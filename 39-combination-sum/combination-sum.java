class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;
        List<List<Integer>> res=new ArrayList<>();

        solve(0,new ArrayList<>(),target,res,candidates,n);

        return res;
    }

    public void solve(int pos,List<Integer> currList,int req,List<List<Integer>> res,int[] candidates,int n) {
        if (req==0) {
            res.add(new ArrayList<>(currList));
            return;
        }

        if (req<0)
            return;

        if (pos==n)
            return;

        //pick
        currList.add(candidates[pos]);
        solve(pos,currList,req-candidates[pos],res,candidates,n);
        currList.remove(currList.size()-1);

        //not pick
        solve(pos+1,currList,req,res,candidates,n);
    }
}

/*
0 -0
   1
   2
   3
*/