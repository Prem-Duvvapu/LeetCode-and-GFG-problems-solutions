//Better
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> resSet=new HashSet<>();

        for (int i=0;i<n;i++) {
            Set<Integer> set=new HashSet<>();
            for (int j=i+1;j<n;j++) {
                if (set.contains(-(nums[i]+nums[j]))) {
                    List<Integer> currList=new ArrayList<>(Arrays.asList(nums[i],nums[j],-(nums[i]+nums[j])));
                    Collections.sort(currList);
                    resSet.add(currList);
                }
                set.add(nums[j]);
            }
        }

        List<List<Integer>> resList=new ArrayList<>(resSet);
        return resList;
    }
}