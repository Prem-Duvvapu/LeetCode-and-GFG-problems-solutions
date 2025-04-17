class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        boolean[] visited=new boolean[n];

        solve(0,new ArrayList<>(),res,visited,nums,n);

        return res;
    }

    public void solve(int pos,List<Integer> currList,List<List<Integer>> res,boolean[] visited,int[] nums,int n) {
        if (pos==n) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                visited[i]=true;
                currList.add(nums[i]);

                solve(pos+1,currList,res,visited,nums,n);

                visited[i]=false;
                currList.remove(currList.size()-1);
            }
        }
    }
}

/* 

for n, we will have n! permuations
[1,2,3]


[3,2,1
*/