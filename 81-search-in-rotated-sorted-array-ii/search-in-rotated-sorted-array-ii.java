class Solution {
    public boolean search(int[] nums, int target) {
        for (int val: nums)
            if (val==target)
                return true;
        return false;
    }
}