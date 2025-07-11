class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        kSum(4,0,(long)target,new ArrayList<>(),res,nums,n);

        return res;
    }

    public void kSum(int k,int pos,long target,List<Integer> currList,List<List<Integer>> res,int[] nums,int n) {
        if (k>2) {
            for (int i=pos;i<n-(k-1);i++) {
                if (i>pos && nums[i]==nums[i-1])
                    continue;

                currList.add(nums[i]);
                kSum(k-1,i+1,target-nums[i],currList,res,nums,n);
                currList.remove(currList.size()-1);
            }
            return;
        }

        int low = pos;
        int high = n-1;

        while (low<high) {
            long currSum = nums[low]+nums[high];

            if (currSum<target) {
                low++;
            } else if (currSum>target) {
                high--;
            } else {
                List<Integer> temp = new ArrayList<>(currList);
                temp.addAll(Arrays.asList(nums[low],nums[high]));
                res.add(temp);

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