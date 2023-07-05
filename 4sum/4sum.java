class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();
        kSum(4, 0, (long)target, nums, res, quad);
        return res;
    }
    
    private void kSum(int k, int start, long target, int[] nums, List<List<Integer>> res, List<Integer> quad) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                quad.add(nums[i]);
                kSum(k - 1, i + 1, target - nums[i], nums, res, quad);
                quad.remove(quad.size() - 1);
            }
            return;
        }
        
        // base case, two sum II
        int left = start;
        int right = nums.length - 1;
        
        while (left < right) {
            if ((long)(nums[left] + nums[right]) < target) {
                left++;
            } else if ((long)(nums[left] + nums[right]) > target) {
                right--;
            } else {
                List<Integer> temp = new ArrayList<>(quad);
                temp.add(nums[left++]);
                temp.add(nums[right--]);
                res.add(temp);
                
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }
}