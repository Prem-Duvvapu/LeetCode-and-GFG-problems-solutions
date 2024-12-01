class Solution {
    public int getLargestOutlier(int[] nums) {
        int n=nums.length;
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        int outlier=-1000;

        for (int num: nums) {
            sum += num;

            if (map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }

        for (int i=0;i<n;i++) {
            int currSum = sum - nums[i];
            int maxNum = currSum/2;

            if (currSum%2==0 && map.containsKey(maxNum)) {
                if (maxNum == nums[i]) {
                     if (map.get(maxNum)>=2)
                        outlier = Math.max(outlier, nums[i]);
                }
                else
                    outlier = Math.max(outlier, nums[i]);
            }
        }

        return outlier;
    }
}