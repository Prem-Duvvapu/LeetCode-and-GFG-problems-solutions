class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        boolean[] visited=new boolean[n];
        solve(nums,visited,res,new ArrayList<>());
        return res;
    }

    private void solve(int[] nums,boolean[] visited,List<List<Integer>> res,List<Integer> currList) {
        if (currList.size()==nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if (!visited[i]) {
                visited[i]=true;
                currList.add(nums[i]);
                solve(nums,visited,res,currList);
                visited[i]=false;
                currList.remove(currList.size()-1);
            }
        }
    }
}