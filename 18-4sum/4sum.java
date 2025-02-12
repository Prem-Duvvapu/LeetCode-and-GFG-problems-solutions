//optimal
//Time: O(nlogn)+O(n^3)
//Space: O(1)+O(no. of unique triplets)

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> resList=new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0;i<n;i++) {
            if (i>0 && nums[i]==nums[i-1])
                continue;

            for (int j=i+1;j<n;j++) {
                if (j>i+1 && nums[j]==nums[j-1])
                    continue;

                int left=j+1;
                int right=n-1;

                while (left<right) {
                    long sum=nums[i]+nums[j];
                    sum+=(nums[left]+nums[right]);
                    if (sum<(long)target) {
                        left++;
                    } else if (sum>(long)target) {
                        right--;
                    } else {
                        List<Integer> res=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        resList.add(res);

                        left++;
                        right--;

                        while (left<right && nums[left]==nums[left-1])
                            left++;

                        while (left<right && nums[right]==nums[right+1])
                            right--;
                    }
                }
            }
        }

        return resList;
    }
}