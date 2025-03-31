class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> currList=new ArrayList<>();
        boolean[] visited=new boolean[n];

        Arrays.sort(nums);

        solve(currList,visited,res,nums,n);
        return res;
    }

    public void solve(List<Integer> currList,boolean[] visited,List<List<Integer>> res,int[] nums,int n) {
        if (currList.size()==n) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=0;i<n;i++) {
            if (visited[i] || (i>0 && !visited[i-1] && nums[i]==nums[i-1]))
                continue;

            visited[i]=true;
            currList.add(nums[i]);
            solve(currList,visited,res,nums,n);
            visited[i]=false;
            currList.remove(currList.size()-1);
        }
    }
}