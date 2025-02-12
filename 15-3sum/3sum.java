//optimal
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        int k=0;
        List<List<Integer>> resList=new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0;i<n;i++) {
            int left=i+1;
            int right=n-1;
            if (i>0 && nums[i]==nums[i-1])
                continue;

            while (left<right) {
                if (nums[left]+nums[right]<k-nums[i])
                    left++;
                else if (nums[left]+nums[right]>k-nums[i])
                    right--;
                else {
                    List<Integer> currList=new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right]));
                    resList.add(currList);
                    left++;
                    right--;
                    while (left<right && nums[left]==nums[left-1])
                        left++;
                    
                    while (right>left && nums[right]==nums[right+1])
                        right--;
                }
            }
        }

        return resList;
    }
}