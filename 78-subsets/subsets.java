class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),res,nums,n);
        return res;
    }

    public void solve(int pos,List<Integer> currList,List<List<Integer>> res,int[] nums,int n) {
        if (pos==n) {
            res.add(new ArrayList<>(currList));
            return;
        }

        //not pick
        solve(pos+1,currList,res,nums,n);

        //pick
        currList.add(nums[pos]);
        solve(pos+1,currList,res,nums,n);
        currList.remove(currList.size()-1);
    }
}

/*
1. subarrays - should be consecutive indexes
[1][2][3][1,2][2,3][1,2,3]

2. subsequences - can be consecutive or increasing order indexes
[][1][2][3][1,2][1,3][2,3][1,2,3]

3. subsets - any order
[][1][2][3][1,2][1,3][3,2][3,2,1]
(1,3) 


1. return all subsequences
2. return subsequences with sum k
3. return cnt of subsequences with sum k

[1, 2, 3]

pick/not pick

*/