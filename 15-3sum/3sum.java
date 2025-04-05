class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();

        Arrays.sort(nums);
        solve(0,new ArrayList<>(),res,0,nums,n);

        return res;
    }

    public void solve(int pos,List<Integer> currList,List<List<Integer>> res,int target,int[] nums,int n) {
        if (currList.size()==0) {
            for (int i=0;i<n;i++) {
                if (i>0 && nums[i]==nums[i-1])
                    continue;

                currList.add(nums[i]);
                solve(i+1,currList,res,target-nums[i],nums,n);
                currList.remove(currList.size()-1);
            }

            return;
        }

        int left=pos;
        int right=n-1;

        while (left<right) {
            int leftVal=nums[left];
            int rightVal=nums[right];

            if (leftVal+rightVal<target)
                left++;
            else if (leftVal+rightVal>target)
                right--;
            else {
                currList.add(nums[left]);
                currList.add(nums[right]);
                res.add(new ArrayList<>(currList));

                currList.remove(currList.size()-1);
                currList.remove(currList.size()-1);

                left++;
                right--;

                while (left<right && nums[left]==nums[left-1])
                    left++;

                while (right>left && nums[right]==nums[right+1])
                    right--;
            }
        }
    }
}