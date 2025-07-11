class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        solve(res,target,nums,n);

        return res;
    }

    private void solve(List<List<Integer>> res,int target,int[] nums,int n) {
        List<Integer> currList = new ArrayList<>();

        for (int i=0;i<n;i++) {
            if (i>0 && nums[i]==nums[i-1])
                continue;
            
            currList.add(nums[i]);

            for (int j=i+1;j<n;j++) {
                if (j>i+1 && nums[j]==nums[j-1])
                continue;
            
                currList.add(nums[j]);
                helper(j+1,currList,res,(long)target-(nums[i]+nums[j]),nums,n);
                currList.remove(currList.size()-1);
            }

            currList.remove(currList.size()-1);
        }
    }

    private void helper(int pos,List<Integer> currList,List<List<Integer>> res,long target,int[] nums,int n) {
        int low= pos;
        int high = n-1;

        while (low<high) {
            long currSum = nums[low]+nums[high];

            if (currSum<target) {
                low++;
            } else if (currSum>target) {
                high--;
            } else {
                currList.add(nums[low]);
                currList.add(nums[high]);
                res.add(new ArrayList<>(currList));
                currList.remove(currList.size()-1);
                currList.remove(currList.size()-1);

                low++;
                high--;

                while (low<high && nums[low]==nums[low-1])
                    low++;

                while (low<high && nums[high]==nums[high+1])
                    high--;
            }
        }
    }
}